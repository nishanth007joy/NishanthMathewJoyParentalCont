package com.nish.parentalcontol.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import com.nish.parentalcontol.exception.TitleNotFoundException;
/**
 * Movie service test
 * @author n.mathew.joy
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
	MovieService movieService = new MovieServiceImpl();
	@Test
	public void testGetParentalControlLevel() {
		assertSame("U", movieService.getParentalControlLevel("Mov2"));
	}
	@Test(expected =TitleNotFoundException.class)
	public void testGetParentalControlLevel_null() {
		movieService.getParentalControlLevel(null);
	}
	
	@Test(expected =TitleNotFoundException.class)
	public void testGetParentalControlLevel_invalid() {
		 movieService.getParentalControlLevel("A");
	}
}
