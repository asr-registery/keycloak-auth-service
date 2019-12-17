package af.asr.keycloakauthservice.data.dto.otp;


import af.asr.keycloakauthservice.data.dto.MosipUserDto;

public class OtpGenerateRequestDto {
	private String key;

	public OtpGenerateRequestDto(MosipUserDto mosipUserDto) {
		this.key = mosipUserDto.getUserId();
	}

	public String getKey() {
		return key;
	}
}
