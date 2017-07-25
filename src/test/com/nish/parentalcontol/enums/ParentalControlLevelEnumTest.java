package com.nish.parentalcontol.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParentalControlLevelEnumTest {

	@Test
	public void testFromCodeU() {
		assertSame(ParentalControlLevelEnum.U,ParentalControlLevelEnum.fromCode("U"));
	}
	@Test
	public void testFromCodePG() {
		assertSame(ParentalControlLevelEnum.PG,ParentalControlLevelEnum.fromCode("PG"));
	}
	@Test
	public void testFromCodeTwelve() {
		assertSame(ParentalControlLevelEnum.Twelve,ParentalControlLevelEnum.fromCode("12"));
	}
	@Test
	public void testFromCodeFifteen() {
		assertSame(ParentalControlLevelEnum.Fifteen,ParentalControlLevelEnum.fromCode("15"));
	}
	@Test
	public void testFromCodeEighteen() {
		assertSame(ParentalControlLevelEnum.Eighteen,ParentalControlLevelEnum.fromCode("18"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFromCodeIllegeal() {
		assertSame(ParentalControlLevelEnum.Eighteen,ParentalControlLevelEnum.fromCode(""));
	}
}
