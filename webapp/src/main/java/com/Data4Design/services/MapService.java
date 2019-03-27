package com.Data4Design.services;

import com.Data4Design.results.StringResult;
import com.Data4Design.services.CountryListService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.Data4Design.results.LongResult;

public class MapService implements IMapService {

	public StringResult getMap(String countryCode) {
		CountryListService countryList = new CountryListService();
		String apiKey = System.getenv("GoogleMapsAPI");// new api key generated. Expires after 12 months.
		String baseUrl = "https://maps.googleapis.com/maps/api/js?key=";
		baseUrl += apiKey;
		baseUrl += "&callback=initMap";

		try {
			URL url = new URL(baseUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

		}

		catch (Exception e) {
			System.out.print("Something went wrong");

		}
		StringResult mapSource = new StringResult();

		System.out.println(baseUrl);

		mapSource.setData(baseUrl);

		return mapSource;
	}

}
