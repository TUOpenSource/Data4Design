package com.Data4Design.services;

import com.Data4Design.results.NumberResult;

public interface IAnnualTemperatureService {

	public NumberResult getAverageAnnualTemperature(String countryCode);
}
