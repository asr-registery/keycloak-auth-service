package af.asr.keycloakauthservice.data.dto.otp.idrepo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class ResponseDTO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RequestDTO extends BaseRequestResponseDTO {

	/** The registration id. */
	private String registrationId;
}
