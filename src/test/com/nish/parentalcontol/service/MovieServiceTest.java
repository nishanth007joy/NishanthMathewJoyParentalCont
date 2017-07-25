package com.nish.parentalcontol.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.nish.parentalcontol.dao.MovieDetailsDao;
import com.nish.parentalcontol.enums.ParentalControlLevelEnum;
import com.nish.parentalcontol.exception.TechnicalFailureException;
import com.nish.parentalcontol.exception.TitleNotFoundException;
import com.nish.parentalcontol.exception.code.BusinessErrorCode;
/**
 * Movie service test
 * @author n.mathew.joy
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
	@InjectMocks
	MovieService movieService = new MovieServiceImpl();
	@Mock
	MovieDetailsDao movieDetailsDao;
	@Test
	public void testGetParentalControlLevel() {
		when(movieDetailsDao.getMovieDetails(any(String.class))).thenReturn(ParentalControlLevelEnum.U.getDescription());
		assertSame("U", movieService.getParentalControlLevel("Mov2"));
	}
	@Test(expected =TechnicalFailureException.class)
	public void testGetParentalControlLevel_null() {
		when(movieDetailsDao.getMovieDetails(any(String.class))).thenThrow(new TechnicalFailureException(BusinessErrorCode.TECH_ERROR001.getCode()));
		movieService.getParentalControlLevel(null);
	}
	
	@Test
	public void testGetParentalControlLevel_invalid() {
		when(movieDetailsDao.getMovieDetails(any(String.class))).thenReturn(null);
		assertNull(movieService.getParentalControlLevel("A"));
	}
}
