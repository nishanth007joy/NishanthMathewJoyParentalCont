package com.nish.parentalcontol.service;

import com.nish.parentalcontol.enums.ParentalControlLevelEnum;
import com.nish.parentalcontol.exception.TechnicalFailureException;
import com.nish.parentalcontol.exception.TitleNotFoundException;
import com.nish.parentalcontol.exception.code.BusinessErrorCode;
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
	public boolean isMovieSatifiesParentalControl(final String parentalControlLevel,final String movieId){
		if(null == parentalControlLevel){
			throw new TitleNotFoundException(BusinessErrorCode.MOV002.getReason());
		}
		String parentalControlLevelRes =movieService.getParentalControlLevel(movieId);
		if(null == parentalControlLevelRes){
			throw new TitleNotFoundException(BusinessErrorCode.MOV001.getReason());
		}
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
