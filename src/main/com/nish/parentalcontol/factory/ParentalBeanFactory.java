package com.nish.parentalcontol.factory;

import com.nish.parentalcontol.dao.MovieDetailsDao;
import com.nish.parentalcontol.dao.MovieDetailsDaoImpl;
import com.nish.parentalcontol.service.MovieService;
import com.nish.parentalcontol.service.MovieServiceImpl;
import com.nish.parentalcontol.service.ParentalControlService;
import com.nish.parentalcontol.service.ParentalControlServiceImpl;
/**
 * Factory class for dependency injection
 * @author Nishanth Mathew Joy
 *
 */
public class ParentalBeanFactory {
	/**
	 * Methord to inject dependency and return service instance called by client
	 * @return
	 */
	public static ParentalControlService getParentalControlService(){
		MovieDetailsDao movieDetailsDao = new MovieDetailsDaoImpl();
		MovieService movieService = new MovieServiceImpl(movieDetailsDao);
		ParentalControlService parentalControlService = 
				new ParentalControlServiceImpl(movieService);
		return parentalControlService;
	}
}
