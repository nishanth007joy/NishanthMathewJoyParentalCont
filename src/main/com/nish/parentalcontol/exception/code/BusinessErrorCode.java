package com.nish.parentalcontol.exception.code;
/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
public enum BusinessErrorCode {
	/**
	 * No movie record found
	 */
	MOV001("NOT_FOUND", "No matching record found for movie."),
	TECH_ERROR001("TECHNICAL_ERROR", "System error.");

	/** Code */
	private final String code;

	/** Reason */
	private final String reason;

	/**
	 * Construct a new BusinessErrorCode with code and reason.
	 *
	 * @param code
	 * @param reason
	 */
	private BusinessErrorCode(String code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	/** @return code */
	public String getCode() {
		return code;
	}

	/** @return reason */
	public String getReason() {
		return reason;
	}
}