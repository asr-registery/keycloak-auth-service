package af.asr.keycloakauthservice.data.dto.otp.idrepo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseDTO extends BaseRequestResponseDTO {

	/** The entity. */
	private String entity;

}
