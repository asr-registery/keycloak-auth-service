/**
 * 
 */
package af.asr.keycloakauthservice.data.repository;

import af.asr.keycloakauthservice.data.dto.*;
import af.asr.keycloakauthservice.data.dto.otp.OtpUser;

import java.util.List;


public interface DataStore  {

	public RolesListDto getAllRoles();

	public MosipUserListDto getListOfUsersDetails(List<String> userDetails) throws Exception;

	public MosipUserSaltListDto getAllUserDetailsWithSalt() throws Exception;

	public RIdDto getRidFromUserId(String userId) throws Exception;
	
	public AuthZResponseDto unBlockAccount(String userId) throws Exception;
	
	public UserRegistrationResponseDto registerUser(UserRegistrationRequestDto userId) ;

	public UserPasswordResponseDto addPassword(UserPasswordRequestDto userPasswordRequestDto);
	
	public AuthZResponseDto changePassword(PasswordDto passwordDto) throws Exception;
	
	public AuthZResponseDto resetPassword(PasswordDto passwordDto) throws Exception;
	
	public UserNameDto getUserNameBasedOnMobileNumber(String mobileNumber) throws Exception;
	
	public MosipUserDto authenticateUser(LoginUser loginUser) throws Exception;

	public MosipUserDto authenticateWithOtp(OtpUser otpUser) throws Exception;

	public MosipUserDto authenticateUserWithOtp(UserOtp loginUser) throws Exception;

	public MosipUserDto authenticateWithSecretKey(ClientSecret clientSecret) throws Exception;
	
	public MosipUserDto getUserRoleByUserId(String username)throws Exception;
	
	public MosipUserDto getUserDetailBasedonMobileNumber(String mobileNumber) throws Exception;
	
	public ValidationResponseDto validateUserName(String userId);
	
	public UserDetailsResponseDto getUserDetailBasedOnUid(List<String> userIds);
	

}
