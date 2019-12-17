package af.asr.keycloakauthservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {

	/** The status. */
	private String status;
	
	/** The message. */
	private String message;
}
