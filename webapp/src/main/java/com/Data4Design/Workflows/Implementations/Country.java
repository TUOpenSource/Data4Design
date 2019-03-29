package com.Data4Design.Workflows.Implementations;

import com.Data4Design.services.CountryListService;

public class Country {
	public String id;
	public String countryName;
	public String iso_3_str;
	public String iso_2_str;
	public CountryInfo countryInfo;
	private static CountryListService converter;
	
	public Country(String str_id) {
		this.id = str_id;
		converter = new CountryListService();
		countryName = converter.getCountryName(str_id);
		iso_3_str = converter.toISO3(str_id);
	}

}
