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

public class AnnualTemperatureServiceCountryInfoItem implements ICountryInfoItemService {

	@Override
	public CountryInfoItem GetCountryInfoItem(Country thisCountry) {
		String uri = String.format("http://climatedataapi.worldbank.org/climateweb/rest/v1/country/annualavg/tas/1980/1999/%s", 
				thisCountry.iso_3_str);
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
		
		CountryInfoItem countryInfoItem = new CountryInfoItem();
		countryInfoItem.setTitle("yearly_temperature");
		String str = DecimalFormat.getNumberInstance().format(temperature);
		str = new DecimalFormat("#.0#").format(temperature);
		countryInfoItem.setValue(str + " degrees Fahrenheit");
		return countryInfoItem;
	}

}
