package com.Data4Design.services;

import org.junit.Test;

public class CountryPopulationServiceTest {

	@Test
	public void testGetPopulation() {
		CountryPopulationService test = new CountryPopulationService();
		test.getPopulation("usa");
	}

	@Test
	public void testGetPopulationBolivia() {
		CountryPopulationService test = new CountryPopulationService();
		test.getPopulation("bol");
	}
}
