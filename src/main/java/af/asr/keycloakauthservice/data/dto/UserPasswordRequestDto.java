package af.asr.keycloakauthservice.data.dto;

import af.asr.keycloakauthservice.util.constant.AuthConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordRequestDto {
	@NotBlank(message= AuthConstant.INVALID_REQUEST)
	private String appId;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String userName;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String rid;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String password;

}
