package com.nish.parentalcontol.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.nish.parentalcontol.enums.ParentalControlLevelEnum;
import com.nish.parentalcontol.exception.TechnicalFailureException;
import com.nish.parentalcontol.exception.TitleNotFoundException;
import com.nish.parentalcontol.exception.code.BusinessErrorCode;
@RunWith(MockitoJUnitRunner.class)
public class ParentalControlServiceTest {
	@InjectMocks
	private ParentalControlService parentalControlService = new ParentalControlServiceImpl();
	@Mock
	private MovieService movieService;
	private final String  MOV_ID = "Mov1";
	/**
	 * Movie restriction less than parental restriction so it should allow to watch movie
	 * @throws TitleNotFoundException
	 * @throws TechnicalFailureException
	 */
	@Test
	public void testIsMovieSatifiesParentalControl_movieRestriction_lessThan_ParentalRestriction() {
		when(movieService.getParentalControlLevel(any(String.class))).thenReturn(ParentalControlLevelEnum.U.getDescription());
		boolean expected = parentalControlService.isMovieSatifiesParentalControl(ParentalControlLevelEnum.PG.getDescription(), MOV_ID);
		assertTrue(expected);
	}
	/**
	 * Movie restriction greater than parental restriction so it should not allow to watch movie
	 * @throws TitleNotFoundException
	 * @throws TechnicalFailureException
	 */
	@Test
	public void testIsMovieSatifiesParentalControl_movieRestriction_greaterThan_ParentalRestriction(){
		when(movieService.getParentalControlLevel(any(String.class))).thenReturn(ParentalControlLevelEnum.Eighteen.getDescription());
		boolean expected = parentalControlService.isMovieSatifiesParentalControl(ParentalControlLevelEnum.PG.getDescription(), MOV_ID);
		assertFalse(expected);
	}
	/**
	 * Movie restriction greater than parental restriction so it should not allow to watch movie
	 * @throws TitleNotFoundException
	 * @throws TechnicalFailureException
	 */
	@Test(expected =TitleNotFoundException.class)
	public void testIsMovieSatifiesParentalControl_null() throws TitleNotFoundException, TechnicalFailureException  {
		when(movieService.getParentalControlLevel(any(String.class))).thenThrow(new TitleNotFoundException(BusinessErrorCode.TECH_ERROR001.getCode()));
		parentalControlService.isMovieSatifiesParentalControl(ParentalControlLevelEnum.PG.getDescription(), null);
	}
}
