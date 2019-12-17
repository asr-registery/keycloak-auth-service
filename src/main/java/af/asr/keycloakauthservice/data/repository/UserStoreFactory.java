/**
 * 
 */
package af.asr.keycloakauthservice.data.repository;

import java.util.Map;

public interface UserStoreFactory {

	Map<String, DataStore> getUserStores();

	DataStore getDataStoreBasedOnApp(String appId);
}
