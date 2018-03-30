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

public class MapService implements IMapService{

	
	public StringResult getMap(String countryCode) {
	
		   //String countryName = CountryListService.getName(countryCode);
		   String countryName = "Bolivia";
	       String baseUrl = "https://maps.googleapis.com/maps/api/staticmap?center=";
	       baseUrl+=countryName;
	       baseUrl +="&zoom=6";
	       baseUrl +="size=800x400";
	       StringResult mapSource = new StringResult();
	       
	        
	        mapSource.setData(baseUrl);

	        return mapSource;
	    }
		
		
	
}
