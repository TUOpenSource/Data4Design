package com.Data4Design.services;

import org.json.simple.JSONObject;
import com.Data4Design.results.LongResult;

/**
 * Makes a call to the CIA World Factbook and returns the value of the total electrification of the country.
 */
public class ElectricityUsageService implements ICIAFactBookService {
    
	 public LongResult getTotalElectricityUsage(String countryCode)
	    {
	        LongResult elecUse= new LongResult();

	        CIAFactBookService factBook = new CIAFactBookService();
	        JSONObject country = factBook.getCIAFactBookCountryObject(countryCode);
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
	            electricityUsage = -1;
	        }

	        elecUse.setData(electricityUsage);
	        return elecUse;
	    }
	    private long electricityUsage;

}
