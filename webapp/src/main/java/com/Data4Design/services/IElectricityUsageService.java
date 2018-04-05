package com.Data4Design.services;

import com.Data4Design.results.NumberResult;

public interface IElectricityUsageService {

    public NumberResult getElectricityUsage(String countryCode);
}
