package com.nish.parentalcontol.service;

import com.nish.parentalcontol.exception.TechnicalFailureException;
import com.nish.parentalcontol.exception.TitleNotFoundException;
/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
public interface MovieService {
	/**
	 * 
	 * @param movieId
	 * @return
	 */
	public String getParentalControlLevel(String movieId);
}
