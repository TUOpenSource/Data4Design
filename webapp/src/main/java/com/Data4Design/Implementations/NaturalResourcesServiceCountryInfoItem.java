package com.Data4Design.Implementations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Implementations.Country;
import com.Data4Design.Workflows.Implementations.CountryInfoItem;
import com.Data4Design.services.CIAFactBookService;

public class NaturalResourcesServiceCountryInfoItem implements ICountryInfoItemService {

	public CountryInfoItem GetCountryInfoItem(Country thisCountry) {
		
        CIAFactBookService factBook = new CIAFactBookService();
        JSONObject country = factBook.getCIAFactBookCountryObject(thisCountry.id);

        try
        {
            JSONObject data = (JSONObject) country.get("data");
            JSONObject geography = (JSONObject) data.get("geography");
            JSONObject naturalResources = (JSONObject) geography.get("natural_resources");
            JSONArray types = (JSONArray) naturalResources.get("resources");
            //String [] arr = new String [types.size()];
            String result = "";
            for(int i = 0; i < types.size(); i++)
            {
                result += (String)types.get(i);
                if(types.size() > (i+1))
                {
                    result += ", ";
                }

            }
            CountryInfoItem countryInfoItem = new CountryInfoItem();
			countryInfoItem.setTitle("natural_resources");
			//String str = DecimalFormat.getNumberInstance().format(result);
			//str = new DecimalFormat("#.0#").format(result);
			countryInfoItem.setValue(result);
			return countryInfoItem;
        }

        catch(NullPointerException e)
        {
           System.out.println("Data not available.");
           
        }

        return null;
	}

}
