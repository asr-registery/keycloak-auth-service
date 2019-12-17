
package af.asr.keycloakauthservice.data.dto.otp.email;

import lombok.Data;

@Data
public class OTPEmailTemplate {
	
	private String emailSubject;
	
	private String emailContent;
	
	private String emailTo;

}
