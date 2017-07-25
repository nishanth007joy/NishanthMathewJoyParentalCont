package com.nish.parentalcontol.service;

import com.nish.parentalcontol.enums.ParentalControlLevelEnum;
import com.nish.parentalcontol.exception.TechnicalFailureException;
import com.nish.parentalcontol.exception.TitleNotFoundException;
/**
 * Parental control service impl
 * @author Nishanth Mathew Joy
 *
 */
public class ParentalControlServiceImpl implements ParentalControlService{
	/**
	 * Default constructor
	 */
	public ParentalControlServiceImpl() {}
	/**
	 * Constructor for injecting dependency from factory method
	 * @param movieService
	 */
	public ParentalControlServiceImpl(MovieService movieService) {
		this.movieService = movieService; 
	}
	private MovieService movieService;

	@Override
	public boolean isMovieSatifiesParentalControl(String parentalControlLevel, String movieId){
		String parentalControlLevelRes =movieService.getParentalControlLevel(movieId);
		ParentalControlLevelEnum parentalConrolLevelEnum = 
				ParentalControlLevelEnum.fromCode(parentalControlLevel);
		ParentalControlLevelEnum parentalConrolLevelResEnum = 
				ParentalControlLevelEnum.fromCode(parentalControlLevelRes);
		if(parentalConrolLevelResEnum.getValue()<= parentalConrolLevelEnum.getValue()){
			return true;
		}else{
			return false;
		}
	}

}
