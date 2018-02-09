package com.Data4Design.webapp;
/**
 * Interface for CountryService
 * @author HHCD
 *
 */
public interface ICountryService {
	
	/** Get list of countries */
	public Country[] getCountries();
	
	/** Get countries based on user input */
	public Country[] getCountries(String str);

}
