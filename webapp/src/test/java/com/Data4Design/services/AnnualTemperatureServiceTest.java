package com.Data4Design.services;

import org.junit.Test;

public class AnnualTemperatureServiceTest {

	@Test
	public void testGetAverageAnnualTemperature() {
		AnnualTemperatureService test = new AnnualTemperatureService();
		test.getAverageAnnualTemperature("bol");
	}

}
