package com.Data4Design.Interfaces;

import com.Data4Design.Workflows.Implementations.CountryInfoItem;

public interface ICountryInfoItemService {
	CountryInfoItem GetCountryInfoItem(String countryName);
}
