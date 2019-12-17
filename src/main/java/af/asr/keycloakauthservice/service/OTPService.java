/**
 * 
 */
package af.asr.keycloakauthservice.service;


import af.asr.keycloakauthservice.data.dto.AuthNResponseDto;
import af.asr.keycloakauthservice.data.dto.MosipUserDto;
import af.asr.keycloakauthservice.data.dto.MosipUserTokenDto;
import af.asr.keycloakauthservice.data.dto.otp.OtpUser;

import java.util.List;



public interface OTPService {

	AuthNResponseDto sendOTP(MosipUserDto mosipUserDto, List<String> channel, String appId);

	MosipUserTokenDto validateOTP(MosipUserDto mosipUser, String otp);

	AuthNResponseDto sendOTPForUin(MosipUserDto mosipUser, List<String> otpChannel, String appId);
	
	AuthNResponseDto sendOTP(MosipUserDto mosipUser, OtpUser otpUser) throws Exception;

}
