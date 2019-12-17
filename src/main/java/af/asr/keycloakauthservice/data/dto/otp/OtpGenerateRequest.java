package af.asr.keycloakauthservice.data.dto.otp;


import af.asr.keycloakauthservice.data.dto.MosipUserDto;

public class OtpGenerateRequest {
	private String key;

	public OtpGenerateRequest(MosipUserDto mosipUserDto) {
		this.key = mosipUserDto.getUserId();
	}

	public String getKey() {
		return key;
	}
}
