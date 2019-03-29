package com.Data4Design.services;

import org.junit.Test;

public class AnnualPrecipitationServiceTest {

	@Test
	public void testGetAnnualPrecipitation() {
		AnnualPrecipitationService test = new AnnualPrecipitationService();
		test.getAnnualPrecipitation("bol");
	}

}
