package com.Data4Design.webapp;
/**
 * Takes selected country name string and initializes a country object.
 */

public class CountryLookupService implements ICountryLookupService{
	
	
	public CountryLookupService() 
	{
		
	}

	@Override
	public Country getCountry(String str) {
		// TODO Auto-generated method stub
		return new Country(str);
	}

}
