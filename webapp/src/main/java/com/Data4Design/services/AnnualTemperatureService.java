package com.Data4Design.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.Data4Design.results.NumberResult;

public class AnnualTemperatureService implements IAnnualTemperatureService {
	
	/** Calculates the average temperature from 15 sources provided by the 
	 *  World Bank API from 1980 to 1999. Returns a NumberResult with a double. */
	public NumberResult getAverageAnnualTemperature(String countryCode) {
		
		String uri = String.format("http://climatedataapi.worldbank.org/climateweb/rest/v1/country/annualavg/tas/1980/1999/%s", 
				countryCode);
		JSONParser parser = new JSONParser();
		double temperature = 0.0;
		double[] rainfallArray = new double[15]; // World Bank Climate API has 15 sources for data

		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			BufferedReader json = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			JSONArray outerArray = (JSONArray) parser.parse(json);
			JSONObject item = null;
			JSONArray rainfallData = null;
			double rainfallForSource = 0.0; // Needed to average the values from the sources
			
			for (int i = 0; i < outerArray.size() && i < rainfallArray.length; i++) {
				item = (JSONObject) outerArray.get(i);
				rainfallData = (JSONArray) item.get("annualData");
				rainfallForSource = (double) rainfallData.get(0);
				rainfallArray[i] = rainfallForSource;
				//System.out.println(rainfallArray[i]); // for debugging
			}
			
			json.close();
		}
		catch(Exception e) {
			System.out.println("ERROR: "+e);
		}
		// calculate average
		double sum = 0.0;
		for(double i : rainfallArray) {
			sum += i;
		}
		temperature = sum / rainfallArray.length; // should always be 15
		System.out.println("Average temperature = "+temperature);
		
		NumberResult temperatureResult = new NumberResult(temperature);
		return temperatureResult;
	}

}
