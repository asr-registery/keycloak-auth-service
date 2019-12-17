
package af.asr.keycloakauthservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {

	private String userId;
	private String accessToken;
	private long expirationTime;
	private String refreshToken;
}
