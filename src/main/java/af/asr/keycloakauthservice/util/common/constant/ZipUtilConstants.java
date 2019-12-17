package af.asr.keycloakauthservice.util.common.constant;

public enum ZipUtilConstants {
	FILE_NOT_FOUND_ERROR_CODE("KER-UTL-401", "File Not Found"),
	IO_ERROR_CODE("KER-UTL-402", "Interrupted IO Operation"),
	NULL_POINTER_ERROR_CODE("KER-UTL-403", "Null Reference found"),
	DATA_FORMATE_ERROR_CODE("KER-UTL-404", "Attempting to unzip file that is not zipped");

	/** Error code. */
	public final String errorCode;

	/** Exception Message */
	public final String message;

	ZipUtilConstants(final String errorCode, final String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

}
