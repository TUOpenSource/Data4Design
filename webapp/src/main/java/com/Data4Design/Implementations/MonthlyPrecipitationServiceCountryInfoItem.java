package com.Data4Design.Implementations;

import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Implementations.Country;
import com.Data4Design.Workflows.Implementations.CountryInfoItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Arrays;


import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class MonthlyPrecipitationServiceCountryInfoItem implements ICountryInfoItemService {

	@Override
	public CountryInfoItem GetCountryInfoItem(Country thisCountry) {
		//http://climatedataapi.worldbank.org/climateweb/rest/v1/country/type/var/start/end/ISO3[.ext]

				String uri = String.format("http://climatedataapi.worldbank.org/climateweb/rest/v1/country/mavg/pr/1980/1999/%s",
								thisCountry.iso_3_str);
				JSONParser parser = new JSONParser();
				double rainfall = 0.0;
        double[] monthArray = new double[12]; // Array to hold every month's average value
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

        for(int monthNumber = 0; monthNumber < 12; monthNumber++){
				  for (int i = 0; i < outerArray.size() && i < rainfallArray.length; i++) {
					  item = (JSONObject) outerArray.get(i);
					  rainfallData = (JSONArray) item.get("monthVals");
					  rainfallForSource = (double) rainfallData.get(monthNumber);
					  rainfallArray[i] = rainfallForSource;
					  //System.out.println(rainfallForSource);
          }
          // calculate average
          double sum = 0.0;
  				for (double i : rainfallArray) {
  					sum += i;
  				}
  				rainfall = sum / rainfallArray.length; // should always be 15
					double roundOff = Math.round(rainfall * 100.0) / 100.0;
					monthArray[monthNumber] = roundOff;
				}

				json.close();
				}
				catch (Exception e) {
					System.out.println("ERROR: "+e);
				}

				//System.out.println(Arrays.toString(monthArray));
				CountryInfoItem countryInfoItem = new CountryInfoItem();
				countryInfoItem.setTitle("monthly_rainfall");
				//String str = DecimalFormat.getNumberInstance().format(rainfall);
				//str = new DecimalFormat("#.0#").format(rainfall);
				countryInfoItem.setValue("{\"January\":" + "\""+monthArray[0]+"\""  +
				"\"February:\"" + "\""+monthArray[1]+"\"" +
				"\"March:\"" + "\""+monthArray[2]+"\"" +
				"\"April:\"" + "\""+monthArray[3]+"\"" +
				"\"May:\"" + "\""+monthArray[4]+"\"" +
				"\"June:\"" + "\""+monthArray[5]+"\"" +
				"\"July:\"" + "\""+monthArray[6]+"\"" +
				"\"August:\"" + "\""+monthArray[7]+"\"" +
				"\"September:\"" + "\""+monthArray[8]+"\"" +
				"\"October:\"" + "\""+monthArray[9]+"\"" +
				"\"November:\"" + "\""+monthArray[10]+"\"" +
				"\"December:\"" + "\""+monthArray[11]+"\"" + "}");
				return countryInfoItem;
	}
}
