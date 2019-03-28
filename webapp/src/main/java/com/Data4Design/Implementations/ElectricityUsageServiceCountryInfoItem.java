package com.Data4Design.Implementations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Implementations.Country;
import com.Data4Design.Workflows.Implementations.CountryInfoItem;

public class ElectricityUsageServiceCountryInfoItem implements ICountryInfoItemService {

	@Override
	public CountryInfoItem GetCountryInfoItem(Country thisCountry) {
		//String dateParam = "date=2016:2016&format=json"; 
        //String uri = String.format("https://api.worldbank.org/v2/countries/%s/indicators/SP.POP.TOTL?%s", countryCode, dateParam);
        String uri = String.format("http://api.worldbank.org/v2/countries/%s/indicators/EG.ELC.ACCS.ZS?format=json&MRV=1", thisCountry.id);
        JSONParser parser = new JSONParser();
        double electricity = 0;
        
        try {
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        BufferedReader json = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        JSONArray jsonArray = (JSONArray) parser.parse(json);
        //System.out.println(jsonArray);
        JSONArray innerJsonArray = (JSONArray) jsonArray.get(1);
        //System.out.println(innerJsonArray);
        JSONObject finallyAnObject = (JSONObject) innerJsonArray.get(0);
        
        electricity = (double) finallyAnObject.get("value"); // need a Result to handle Longs!!!!!!!
        System.out.println("Electricity Usage of "+thisCountry.countryName+" = "+electricity);
        //NumberResult.data = population ---> how to pass values to results when there isn't a
        // constructor or a set method? NumberResult.data is protected (default access modifier)
                
        json.close();
        
        }
        
        catch (Exception e) {
            System.out.println("ERROR: "+e);
        }

        CountryInfoItem countryInfoItem = new CountryInfoItem();
		countryInfoItem.setTitle("electricity_usage");
		String str = DecimalFormat.getNumberInstance().format(electricity);
		str = new DecimalFormat("#.0#").format(electricity);
		countryInfoItem.setValue(str + " units");
		return countryInfoItem;
	}

}
