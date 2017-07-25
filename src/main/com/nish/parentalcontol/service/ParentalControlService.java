package com.nish.parentalcontol.service;

import com.nish.parentalcontol.exception.TechnicalFailureException;
import com.nish.parentalcontol.exception.TitleNotFoundException;

/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
public interface ParentalControlService {
	/**
	 * 
	 * @param parentalControlLevel
	 * @param movieId
	 * @return
	 * @throws TitleNotFoundException
	 * @throws TechnicalFailureException
	 */
public boolean isMovieSatifiesParentalControl(String parentalControlLevel, String movieId); 
}
