
package af.asr.keycloakauthservice.data.dto;

import lombok.Data;

@Data
public class BasicTokenDto {

	private String authToken;
	private String refreshToken;
	private long expiryTime;
}
