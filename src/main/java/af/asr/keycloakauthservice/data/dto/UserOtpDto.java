
package af.asr.keycloakauthservice.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class UserOtpDto extends BaseRequestResponseDto {

	private UserOtp request;

}
