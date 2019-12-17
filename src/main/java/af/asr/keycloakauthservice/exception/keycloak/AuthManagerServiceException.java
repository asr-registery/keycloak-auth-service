/**
 * 
 */
package af.asr.keycloakauthservice.exception.keycloak;

import af.asr.keycloakauthservice.exception.common.ServiceError;

import java.util.ArrayList;
import java.util.List;


public class AuthManagerServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3980982936992909434L;
	/**
	 * This variable holds the MosipErrors list.
	 */
	private List<ServiceError> list = new ArrayList<>();

	/**
	 * @param list The error list.
	 */
	public AuthManagerServiceException(List<ServiceError> list) {
		this.list = list;
	}

	/**
	 * Getter for error list.
	 * 
	 * @return The error list.
	 */
	public List<ServiceError> getList() {
		return list;
	}
}
