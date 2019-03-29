package com.Data4Design.Implementations;


import java.text.DecimalFormat;
import org.json.simple.JSONObject;
import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Implementations.Country;
import com.Data4Design.Workflows.Implementations.CountryInfoItem;
import com.Data4Design.services.CIAFactBookService;

public class ElectricityUsageServiceCountryInfoItem implements ICountryInfoItemService {

	@Override
	public CountryInfoItem GetCountryInfoItem(Country thisCountry) {
		{
	        CIAFactBookService factBook = new CIAFactBookService();
	        JSONObject country = factBook.getCIAFactBookCountryObject(thisCountry.id);
	        try
	        {
	            JSONObject dataObject = (JSONObject) country.get("data");
	            JSONObject energy = (JSONObject) dataObject.get("energy");
	            JSONObject electricityObject = (JSONObject) energy.get("electricity");
	            JSONObject access = (JSONObject) electricityObject.get("access");
	            JSONObject total = (JSONObject) access.get("total_electrification");
	            electricityUsage = (long) total.get("value");
	        }

	        catch(NullPointerException e)
	        {
	            System.out.println("Data not available.");
	            electricityUsage = 0;
	        }

	    }

        CountryInfoItem countryInfoItem = new CountryInfoItem();
		countryInfoItem.setTitle("electricity_usage");
		String str = DecimalFormat.getNumberInstance().format(electricityUsage);
		str = new DecimalFormat("#.0#").format(electricityUsage);
		countryInfoItem.setValue(str + " units");
		return countryInfoItem;
	}
	private long electricityUsage;

}
