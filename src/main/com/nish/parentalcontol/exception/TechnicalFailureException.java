package com.nish.parentalcontol.exception;
/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
public class TechnicalFailureException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	  /**
	   * Construct BadRequestException with message.
	   *
	   * @param message
	   */
	  public TechnicalFailureException(String message) {
	    super(message);
	  }
}
