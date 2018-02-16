package com.Data4Design.webapp;

//import java.util.List;
import java.util.ArrayList;

public class CountryService implements ICountryService {

	private ICountryService iCountryService;
	private IFileReader iFileReader;
	
	public CountryService(ICountryService iCountryService) {
		this.iCountryService = iCountryService;
	}
	
	@Override
	public ArrayList<String> getCountries() {
		// TODO Auto-generated method stub
		ArrayList<String> countryList = iFileReader.readFile("countries.txt");
		return countryList;
	}
	
}
