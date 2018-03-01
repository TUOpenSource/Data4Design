package com.Data4Design.webapp;

import java.util.ArrayList;

public class CountryService implements ICountryService {

	private IFileReader iFileReader;
	
	public CountryService(IFileReader iFileReader) {
		this.iFileReader = iFileReader;
	}
		
	@Override
	public ArrayList<String> getCountries() {
		// TODO Auto-generated method stub
		ArrayList<String> countryList = iFileReader.readFile("src/main/resources/countries.txt");
		return countryList;
	}
	
}
