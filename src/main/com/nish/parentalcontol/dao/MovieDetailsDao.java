package com.nish.parentalcontol.dao;

import java.util.Map;

/**
 * This is the DB read or update logic class.
 * @author n.mathew.joy
 *
 */
public interface MovieDetailsDao {
	/**
	 * This methors reads restriction aginst a movie
	 * @param movieId
	 * @return
	 */
	public String getMovieDetails(String movieId);
}
