package com.Data4Design.webapp;
/**
 * Implementation of ICountryService
 * @author HHCD
 *
 */

public class CountryService implements ICountryService {

	private CountryParser jsonParser;
	
	@Override
	public Country[] getCountries() {
		// TODO Auto-generated method stub
		Country[] countryList = jsonParser.parseFile("filename");
		return countryList;
	}

	@Override
	public Country[] getCountries(String str) {
		// TODO Auto-generated method stub
		Country[] countryList = jsonParser.parseFile("filename", str);
		return countryList;
	}
	
}
