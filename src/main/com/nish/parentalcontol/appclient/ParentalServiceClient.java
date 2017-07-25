package com.nish.parentalcontol.appclient;

import com.nish.parentalcontol.exception.TechnicalFailureException;
import com.nish.parentalcontol.exception.TitleNotFoundException;
import com.nish.parentalcontol.factory.ParentalBeanFactory;
import com.nish.parentalcontol.service.ParentalControlService;
/**
 * Main client program
 * @author Nishanth Mathew Joy
 *
 */
public class ParentalServiceClient {
	private static final String parentalControlLevel = "PG";
	private static final String movieId = "Mov1";
	/**
	 * 
	 * @param args
	 * @throws TitleNotFoundException
	 * @throws TechnicalFailureException
	 */
	public static void main(String[] args) throws TitleNotFoundException, TechnicalFailureException {
		ParentalControlService parentalControlService = 
				ParentalBeanFactory.getParentalControlService();
		boolean isMovieAllowed = parentalControlService.isMovieSatifiesParentalControl(parentalControlLevel, movieId);
		
		System.out.println("Output for Movie id "+movieId +" and parentalControlLevel "+parentalControlLevel +" is " + isMovieAllowed);
	} 
}
