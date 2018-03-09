package com.Data4Design.services;

import com.Data4Design.results.NumberResult;

public interface ICountryPopulationService {

	public NumberResult getPopulation(String countryCode);
}
