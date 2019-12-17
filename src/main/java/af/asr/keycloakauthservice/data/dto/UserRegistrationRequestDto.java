package af.asr.keycloakauthservice.data.dto;

import af.asr.keycloakauthservice.util.constant.AuthConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequestDto {
	@NotBlank(message= AuthConstant.INVALID_REQUEST)
	private String userName;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String firstName;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String lastName;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String contactNo;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String emailID;
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull
	private LocalDate dateOfBirth;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String gender;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String role;
	@NotBlank(message=AuthConstant.INVALID_REQUEST)
	private String appId;
}
