/**
 * 
 */
package af.asr.keycloakauthservice.service;


import af.asr.keycloakauthservice.data.dto.MosipUserTokenDto;

public interface AuthZService {

	MosipUserTokenDto validateToken(String token) throws Exception;

}
