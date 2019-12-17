package af.asr.keycloakauthservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MosipUserTokenDto {
	private MosipUserDto mosipUserDto;
	private String token;
	private String refreshToken;
	private long expTime;
	private String message;
	private String status;
}
