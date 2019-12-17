package af.asr.keycloakauthservice.data.dto.otp;

import lombok.Data;

/**
 * The DTO class for sms notification response.
 */
@Data
public class SmsResponseDto {

	/**
	 * Response status.
	 */
	private String status;

	/**
	 * Response message
	 */
	private String message;
}
