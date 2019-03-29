package com.Data4Design.services;

import org.junit.Test;

public class CityRainfallServiceTest {

	@Test
	public void testGetRainfall() {
		RainfallService test = new RainfallService();
		test.getRainfall("Tulsa");
	}

}
