
package af.asr.keycloakauthservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientSecret {

	private String clientId;
	private String secretKey;
	private String appId;
}
