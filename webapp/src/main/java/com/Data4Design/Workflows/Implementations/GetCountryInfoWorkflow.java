package com.Data4Design.Workflows.Implementations;

import java.util.Collection;
import java.util.stream.Collectors;

import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Interfaces.IGetCountryInfoWorkflow;

public class GetCountryInfoWorkflow implements IGetCountryInfoWorkflow {
	
	private Collection<ICountryInfoItemService> iCountryInfoItemServices;

	public GetCountryInfoWorkflow(Collection<ICountryInfoItemService> iCountryInfoItemServices) throws Exception {
		
		if(iCountryInfoItemServices == null)
			throw new Exception("iCountryInfoItemServices");
		
		this.iCountryInfoItemServices = iCountryInfoItemServices;
	}
	
	@Override
	public CountryInfo GetCountryInfo(String countryName) throws Exception {
		
		if(countryName.equals(null))
			throw new Exception(countryName);
		
		CountryInfo countryInfo = new CountryInfo();
		countryInfo.CountryInfoItems = GetCountryInfoItems(countryName);
		return countryInfo;
	}
	
	private Collection<CountryInfoItem> GetCountryInfoItems(String countryName){
		return  iCountryInfoItemServices
				.stream()
				.map(iCountryInfoItemService -> iCountryInfoItemService.GetCountryInfoItem(countryName))
				.filter(countryInfoItem -> countryInfoItem != null)
				.collect(Collectors.toList());
	}

}
