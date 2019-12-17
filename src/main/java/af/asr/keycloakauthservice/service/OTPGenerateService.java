/**
 * 
 */
package af.asr.keycloakauthservice.service;


import af.asr.keycloakauthservice.data.dto.MosipUserDto;
import af.asr.keycloakauthservice.data.dto.otp.OtpGenerateResponseDto;
import af.asr.keycloakauthservice.data.dto.otp.OtpUser;

public interface OTPGenerateService {

	OtpGenerateResponseDto generateOTP(MosipUserDto mosipUserDto, String token);
	OtpGenerateResponseDto generateOTPMultipleChannels(MosipUserDto mosipUserDto, OtpUser otpUser, String token);

}
