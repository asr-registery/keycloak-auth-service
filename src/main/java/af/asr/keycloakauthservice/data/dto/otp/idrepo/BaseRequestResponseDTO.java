package af.asr.keycloakauthservice.data.dto.otp.idrepo;

import lombok.Data;

import java.util.List;

/**
 * The Class ResponseDTO.
 */
@Data
public class BaseRequestResponseDTO {

	/** The status. */
	private String status;

	/** The identity. */
	private Object identity;

	private List<Documents> documents;
}
