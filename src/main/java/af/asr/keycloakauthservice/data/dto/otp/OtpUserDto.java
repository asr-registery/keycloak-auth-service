/**
 * 
 */
package af.asr.keycloakauthservice.data.dto.otp;

import af.asr.keycloakauthservice.data.dto.BaseRequestResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class OtpUserDto extends BaseRequestResponseDto {

	private OtpUser request;

}
