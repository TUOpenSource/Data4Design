package com.Data4Design.services;

import java.net.HttpURLConnection;
import java.net.URL;

import com.Data4Design.results.StringResult;

public class MapService implements IMapService {

	public StringResult getMap(String countryCode) {
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
