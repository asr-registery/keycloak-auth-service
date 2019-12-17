
package af.asr.keycloakauthservice.data.dto;

import lombok.Data;

@Data
public class TimeToken {

	private String token;
	private long expTime;

}
