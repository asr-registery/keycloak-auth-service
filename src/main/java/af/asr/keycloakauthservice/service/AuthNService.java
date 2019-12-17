/**
 * 
 */
package af.asr.keycloakauthservice.service;


import af.asr.keycloakauthservice.data.dto.AuthNResponseDto;
import af.asr.keycloakauthservice.data.dto.ClientSecret;
import af.asr.keycloakauthservice.data.dto.LoginUser;
import af.asr.keycloakauthservice.data.dto.UserOtp;
import af.asr.keycloakauthservice.data.dto.otp.OtpUser;

public interface AuthNService {

	AuthNResponseDto authenticateUser(LoginUser loginUser) throws Exception;

	AuthNResponseDto authenticateWithOtp(OtpUser otpUser) throws Exception;

	AuthNResponseDto authenticateUserWithOtp(UserOtp loginUser) throws Exception;

	AuthNResponseDto authenticateWithSecretKey(ClientSecret clientSecret) throws Exception;

}
