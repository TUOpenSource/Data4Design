package com.Data4Design.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnnualPrecipitationServiceTest {

	@Test
	public void testGetAnnualPrecipitation() {
		AnnualPrecipitationService test = new AnnualPrecipitationService();
		test.getAnnualPrecipitation("bol");
	}

}
