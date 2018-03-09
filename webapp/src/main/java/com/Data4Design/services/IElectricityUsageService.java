package com.Data4Design.services;

import com.Data4Design.results.LongResult;

public interface IElectricityUsageService {

    public LongResult getElectricityUsage(String countryCode);
}
