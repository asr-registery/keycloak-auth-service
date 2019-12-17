package af.asr.keycloakauthservice.data.dto;

import lombok.Data;


/**
 * Instantiates a new keycloak error response dto.
 */
@Data
public class KeycloakErrorResponseDto {

	/** The error. */
	private String error;
	
	/** The error description. */
	private String error_description;
}
