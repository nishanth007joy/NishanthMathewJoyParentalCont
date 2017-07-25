package com.nish.parentalcontol.service;

import java.util.HashMap;
import java.util.Map;

import com.nish.parentalcontol.dao.MovieDetailsDao;
import com.nish.parentalcontol.exception.TechnicalFailureException;
import com.nish.parentalcontol.exception.TitleNotFoundException;
import com.nish.parentalcontol.exception.code.BusinessErrorCode;
/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
public class MovieServiceImpl implements MovieService{
	MovieDetailsDao movieDetailsDao;
	/**
	 * 
	 * @param movieDetailsDao
	 */
	public MovieServiceImpl(MovieDetailsDao movieDetailsDao) {
		this.movieDetailsDao = movieDetailsDao;
	}
	/**
	 * This is set on a private
	 */
//	private Map<String,String> movieMap;
//	{
//		movieMap = new HashMap<>();
//		movieMap.put("Mov1", "PG");
//		movieMap.put("Mov2", "U");
//		movieMap.put("Mov3", "12");
//		movieMap.put("Mov3", "15");
//		movieMap.put("Mov3", "18");
//	}
	@Override
	public String getParentalControlLevel(String movieId){
		return movieDetailsDao.getMovieDetails(movieId);
//		if(movieMap.containsKey(movieId) && null != movieMap.get(movieId)){
//			return movieMap.get(movieId);
//		}else{
//			throw new TitleNotFoundException(BusinessErrorCode.TECH_ERROR001.getCode());
//		}

	}
}
