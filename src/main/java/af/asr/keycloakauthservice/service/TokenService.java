
package af.asr.keycloakauthservice.service;


import af.asr.keycloakauthservice.data.dto.AuthToken;
import af.asr.keycloakauthservice.data.dto.TimeToken;

public interface TokenService {

	void StoreToken(AuthToken token);
	
	void UpdateToken(AuthToken token);

	AuthToken getTokenDetails(String token);

	AuthToken getUpdatedAccessToken(String token, TimeToken newAccessToken, String userName);

	void revokeToken(String token);
	
	AuthToken getTokenBasedOnName(String userName);

}
