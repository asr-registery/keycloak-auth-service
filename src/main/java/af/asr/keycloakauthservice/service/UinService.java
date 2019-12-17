
package af.asr.keycloakauthservice.service;


import af.asr.keycloakauthservice.data.dto.MosipUserDto;
import af.asr.keycloakauthservice.data.dto.otp.OtpUser;

public interface UinService {

	MosipUserDto getDetailsFromUin(OtpUser otpUser) throws Exception;
	
	MosipUserDto getDetailsForValidateOtp(String uin) throws Exception;
}
