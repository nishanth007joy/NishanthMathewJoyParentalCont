package com.nish.parentalcontol.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nish.parentalcontol.service.ParentalControlService;

public class ParentalBeanFactoryTest {

	@Test
	public void testGetParentalControlService() {
		ParentalControlService parentalControlService = 
				ParentalBeanFactory.getParentalControlService();
		assertNotNull(parentalControlService);
	}

}
