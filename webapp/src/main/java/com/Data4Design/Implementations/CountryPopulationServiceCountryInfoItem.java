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

public class CountryPopulationServiceCountryInfoItem implements ICountryInfoItemService {

	@Override
	public CountryInfoItem GetCountryInfoItem(Country thisCountry) {
		String dateParam = "date=2016:2016&format=json"; 
		String uri = String.format("https://api.worldbank.org/v2/countries/%s/indicators/SP.POP.TOTL?%s", 
						thisCountry.id, dateParam);
		JSONParser parser = new JSONParser();
		long population = 0;
		
		try {
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		BufferedReader json = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		JSONArray jsonArray = (JSONArray) parser.parse(json);
		JSONArray innerJsonArray = (JSONArray) jsonArray.get(1);
		JSONObject finallyAnObject = (JSONObject) innerJsonArray.get(0);
		
		population = (Long) finallyAnObject.get("value");
		
		json.close();
		
		}
		
		catch (Exception e) {
			System.out.println("ERROR: "+e);
		}
		
		
		CountryInfoItem countryInfoItem = new CountryInfoItem();
		countryInfoItem.setTitle("population");
		String str = DecimalFormat.getNumberInstance().format(population);
		// str = new DecimalFormat("#.0#").format(population);
		countryInfoItem.setValue(str );
		return countryInfoItem;
	}

}
