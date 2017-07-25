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
	public MovieServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This is set on a private
	 */

	@Override
	public String getParentalControlLevel(String movieId){
		return movieDetailsDao.getMovieDetails(movieId);
	}
}
