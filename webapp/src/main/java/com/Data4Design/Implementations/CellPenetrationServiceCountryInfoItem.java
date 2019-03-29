package com.Data4Design.Implementations;

import java.text.DecimalFormat;

import org.json.simple.JSONObject;

import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Implementations.Country;
import com.Data4Design.Workflows.Implementations.CountryInfoItem;
import com.Data4Design.results.LongResult;
import com.Data4Design.services.CIAFactBookService;

public class CellPenetrationServiceCountryInfoItem implements ICountryInfoItemService {
	
	private long cellPenetration;
	
	@Override
	public CountryInfoItem GetCountryInfoItem(Country thisCountry) {

	        CIAFactBookService factBook = new CIAFactBookService();
	        JSONObject country = factBook.getCIAFactBookCountryObject(thisCountry.id);
	        try
	        {
	            JSONObject dataObject = (JSONObject) country.get("data");
	            JSONObject communications = (JSONObject) dataObject.get("communications");
	            JSONObject telephoneObject = (JSONObject) communications.get("telephones");
	            JSONObject mobile = (JSONObject) telephoneObject.get("mobile_cellular");
	            cellPenetration = (long) mobile.get("subscriptions_per_one_hundred_inhabitants");
	        }

	        catch(NullPointerException e)
	        {
	            System.out.println("Data not available.");
	            cellPenetration = -1;
	        }
        
        CountryInfoItem countryInfoItem = new CountryInfoItem();
		countryInfoItem.setTitle("cell_penetration");
		String str = DecimalFormat.getNumberInstance().format(cellPenetration);
		str = new DecimalFormat("#.0#").format(cellPenetration);
		countryInfoItem.setValue(str + " units");
		return countryInfoItem;

        
	}

}
