/**
 * 
 */
package af.asr.keycloakauthservice.data.repository.impl;

import af.asr.keycloakauthservice.data.dto.DataBaseProps;
import af.asr.keycloakauthservice.data.repository.DataStore;
import af.asr.keycloakauthservice.data.repository.UserStoreFactory;
import af.asr.keycloakauthservice.exception.keycloak.AuthManagerException;
import af.asr.keycloakauthservice.util.constant.AuthConstant;
import af.asr.keycloakauthservice.util.constant.AuthErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class UserStoreFactoryImpl implements UserStoreFactory {

	@Autowired
	private MosipEnvironment mosipEnvironment;

	private Map<String, DataStore> dataStoreMap = null;
	
	@Value("${hikari.maximumPoolSize:25}")
	private int maximumPoolSize;
	@Value("${hikari.validationTimeout:3000}")
	private int validationTimeout;
	@Value("${hikari.connectionTimeout:60000}")
	private int connectionTimeout;
	@Value("${hikari.idleTimeout:200000}")
	private int idleTimeout;
	@Value("${hikari.minimumIdle:0}")
	private int minimumIdle;
	@Value("${iam.datastore.commonname}")
	private String commonname;
	@Value("${ldap.admin.dn:uid=admin,ou=system}")
	private String adminDN;
	@Value("${ldap.admin.password:secret}")
	private String adminPassword;

	UserStoreFactoryImpl() {

	}

	@PostConstruct
	private void init() {
		buildDataStoreMap();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.mosip.kernel.auth.factory.UserStoreFactory#getUserStores()
	 */
	@Override
	public Map<String, DataStore> getUserStores() {
		return dataStoreMap;
	}

	public void buildDataStoreMap() {
		dataStoreMap = new HashMap<>();
		String datasources = mosipEnvironment.getDataStores();
		List<String> dataStoreList = Arrays.asList(datasources.split("\\s*,\\s*"));

		for (String ds : dataStoreList) {
			if (dataStoreMap.get(ds) == null) {
				DataBaseProps dataBaseConfig = new DataBaseProps();
				dataBaseConfig.setUrl(mosipEnvironment.getUrl(ds));
				dataBaseConfig.setPort(mosipEnvironment.getPort(ds));
				dataBaseConfig.setUsername(mosipEnvironment.getUserName(ds));
				dataBaseConfig.setPassword(mosipEnvironment.getPassword(ds));
				dataBaseConfig.setDriverName(mosipEnvironment.getDriverName(ds));
				dataBaseConfig.setCommonName(commonname);
				dataBaseConfig.setAdminDN(adminDN);
				dataBaseConfig.setAdminPassword(adminPassword);
				dataBaseConfig.setSchemas(ds);
				if (ds.contains(AuthConstant.LDAP)) {
					DataStore idatastore = new LdapDataStore(dataBaseConfig);
					dataStoreMap.put(ds, idatastore);
				} else {
					DataStore idatastore = new DBDataStore(dataBaseConfig,maximumPoolSize,validationTimeout,connectionTimeout,idleTimeout,minimumIdle);
					dataStoreMap.put(ds, idatastore);
				}

			}

		}
	}

	@Override
	public DataStore getDataStoreBasedOnApp(String appId) {
		String datasource = null;
		if (appId != null) {
			datasource = mosipEnvironment.getDataStore(appId.toLowerCase() + AuthConstant.DATASOURCE);
		}
		if(datasource==null)
		{
			throw new AuthManagerException(AuthErrorCode.INVALID_DATASOURCE_ERROR.getErrorCode(),AuthErrorCode.INVALID_DATASOURCE_ERROR.getErrorMessage());
		}
		return dataStoreMap.get(datasource);
	}

}
