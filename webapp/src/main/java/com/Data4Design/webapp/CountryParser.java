package com.Data4Design.webapp;

/**
 * 
 * Implementation of IJSONParsingService for Country
 * 
 * @author HHCD
 *
 */

public class CountryParser implements IJSONParsingService<Country> {

	public Country[] parseFile(String filename) {
		// TODO Auto-generated method stub
		// temporary values
		Country c1 = new Country("Austria");
		Country c2 = new Country("Belgium");
		Country[] countryList = { c1, c2 };
		return countryList;
	}

	public Country[] parseFile(String filename, String inquiry) {
		// temporary values
		Country c1 = new Country("Austria");
		Country c2 = new Country("Belgium");
		Country[] countryList = { c1, c2 };
		return countryList;
	}

}
