package af.asr.keycloakauthservice.data.dto;

import lombok.Data;

import java.util.List;


/**
 * 
 * Instantiates a new user details response dto.
 */
@Data
public class UserDetailsResponseDto {

	/** The user details. */
	List<UserDetailsDto> userDetails;
}
