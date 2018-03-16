package com.Data4Design.services;

import com.Data4Design.results.LongResult;

public interface ICountryPopulationService {

	public LongResult getPopulation(String countryCode);
}
