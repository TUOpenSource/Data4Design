package com.Data4Design.webapp;
/**
 * Gets list of countries from data source for drop-down menu.
 * @author HHCD
 *
 */
import java.util.ArrayList;

public interface ICountryService {
	
	/** Get list of countries */
	public ArrayList<String> getCountries();
	
}
