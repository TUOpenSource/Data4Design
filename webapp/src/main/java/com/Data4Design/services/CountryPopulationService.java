package com.Data4Design.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import com.Data4Design.results.LongResult;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * Makes a call to World Bank API to get the population of a specified 
 * country. Whittles JSON arrays down to the population value. Needs to return
 * some form of NumberResult, but NumberResult doesn't currently handle longs....
 */
public class CountryPopulationService implements ICountryPopulationService {
	
	@Override
	public LongResult getPopulation(String countryCode) {
		String dateParam = "date=2016:2016&format=json"; 
		String uri = String.format("https://api.worldbank.org/v2/countries/%s/indicators/SP.POP.TOTL?%s", 
						countryCode, dateParam);
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
		LongResult countryPopulation = new LongResult(population);
		System.out.println("Population of "+countryCode+" = "+countryPopulation.fetchData());
		return countryPopulation;
	}

}
