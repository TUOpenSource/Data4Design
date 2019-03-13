package com.Data4Design.Workflows.Interfaces;

import com.Data4Design.Workflows.Implementations.CountryInfo;

public interface IGetCountryInfoWorkflow{
	CountryInfo GetCountryInfo(String countryName) throws Exception;
}
