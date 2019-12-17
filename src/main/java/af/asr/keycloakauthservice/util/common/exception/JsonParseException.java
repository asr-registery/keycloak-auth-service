package af.asr.keycloakauthservice.util.common.exception;


import af.asr.keycloakauthservice.exception.common.BaseCheckedException;

public class JsonParseException extends BaseCheckedException {
	private static final long serialVersionUID = 7469054823823721387L;

	public JsonParseException(String errorCode, String errorMessage, Throwable rootCause) {
		super(errorCode, errorMessage, rootCause);

	}

}
