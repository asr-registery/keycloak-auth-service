package af.asr.keycloakauthservice.data.dto.otp;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OtpUser {
	private String userId;
	private List<String> otpChannel;
	private String appId;
	private String useridtype;
	private Map<String,Object> templateVariables;
	private String context;
}
