
package af.asr.keycloakauthservice.data.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientSecretDto extends BaseRequestResponseDto {

	private ClientSecret request;

}
