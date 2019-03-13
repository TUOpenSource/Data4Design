package com.Data4Design.Workflows.Implementations;

import java.util.Collection;

public class CountryInfo {
	public Collection<CountryInfoItem> CountryInfoItems;
	
	public Collection<CountryInfoItem> getCountryInfoItems(){
		return CountryInfoItems;
	}
	
	public void setCountryInfoItems(Collection<CountryInfoItem> countryInfoItems) {
		CountryInfoItems = countryInfoItems;
	}
	
	
}
