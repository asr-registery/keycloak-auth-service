package af.asr.keycloakauthservice.data.dto.otp;

import lombok.Data;

/**
 * The DTO class for OTP Validation response.
 */
@Data
public class OtpValidatorResponseDto {
	/**
	 * The validation request status.
	 */
	private String status;
	/**
	 * The validation request message.
	 */
	private String message;
}
