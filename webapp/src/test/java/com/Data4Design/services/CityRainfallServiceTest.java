package com.Data4Design.services;
import static org.junit.Assert.*;

import org.junit.Test;


public class CityRainfallServiceTest {

	@Test
	public void testGetRainfall() {
		RainfallService test=new RainfallService();
		test.getRainfall("Tulsa");
	}

}
