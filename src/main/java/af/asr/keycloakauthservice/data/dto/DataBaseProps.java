/**
 * 
 */
package af.asr.keycloakauthservice.data.dto;

import lombok.Data;

@Data
public class DataBaseProps {
	private String url;
	private String port;
	private String username;
	private String password;
	private String schemas;
	private String driverName;
	private String commonName;
	private String adminDN;
	private String adminPassword;
}
