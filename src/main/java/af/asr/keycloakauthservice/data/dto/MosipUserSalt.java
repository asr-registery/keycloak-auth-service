
package af.asr.keycloakauthservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MosipUserSalt {
	
	private String userId;
	private String salt;

}
