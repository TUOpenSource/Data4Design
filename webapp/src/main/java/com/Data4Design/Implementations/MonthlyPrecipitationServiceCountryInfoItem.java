package com.Data4Design.Implementations;

import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Implementations.CountryInfoItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class MonthlyPrecipitationServiceCountryInfoItem implements ICountryInfoItemService {

	@Override
	public CountryInfoItem GetCountryInfoItem(String countryName) { //Jan=1, Feb=2, etc
		//http://climatedataapi.worldbank.org/climateweb/rest/v1/country/type/var/start/end/ISO3[.ext]

				String uri = String.format("http://climatedataapi.worldbank.org/climateweb/rest/v1/country/mavg/pr/1980/1999/%s",
								countryName);
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
          //round value to 2 decimals
          DecimalFormat df2 = new DecimalFormat("##.##");
          rainfall = Double.valueOf(df2.format(rainfall));

          monthArray[monthNumber] = rainfall;
				}

				json.close();
				}
				catch (Exception e) {
					System.out.println("ERROR: "+e);
				}

				CountryInfoItem countryInfoItem = new CountryInfoItem();
				countryInfoItem.setTitle("monthly_rainfall");
				//String str = DecimalFormat.getNumberInstance().format(rainfall);
				//str = new DecimalFormat("#.0#").format(rainfall);
				countryInfoItem.setValue("\nJanuary: " + monthArray[0] + " mm\n" +
        "February: " + monthArray[1] + " mm\n" +
        "March: " + monthArray[2] + " mm\n" +
        "April: " + monthArray[3] + " mm\n" +
        "May: " + monthArray[4] + " mm\n" +
        "June: " + monthArray[5] + " mm\n" +
        "July: " + monthArray[6] + " mm\n" +
        "August: " + monthArray[7] + " mm\n" +
        "September: " + monthArray[8] + " mm\n" +
        "October: " + monthArray[9] + " mm\n" +
        "November: " + monthArray[10] + " mm\n" +
        "December: " + monthArray[11] + " mm\n");
				return countryInfoItem;
	}
}
