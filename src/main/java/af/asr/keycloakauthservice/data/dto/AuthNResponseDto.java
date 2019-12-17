
package af.asr.keycloakauthservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthNResponseDto {

	private String token;

	private String message;

	private String refreshToken;

	private long expiryTime;

	private String userId;

	private String status;

}
