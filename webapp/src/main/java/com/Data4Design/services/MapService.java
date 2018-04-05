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
	       CountryListService countryList = new CountryListService();
		   String countryName = countryList.getCountryName(countryCode);
		   String apiKey = "AIzaSyBwhOcDvZryXjm3ZSUxHHEHeRQflJH5ctc";

	       String baseUrl = "https://maps.googleapis.com/maps/api/staticmap?center=";
	       baseUrl+=countryName;
	       baseUrl +="&zoom=6";
	       baseUrl +="&size=800x400";
	       baseUrl += "&key=";
	       baseUrl +=apiKey;
	       
	       try {
	    	       URL url = new URL(baseUrl);
	           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	           connection.setRequestMethod("GET");
	           
	    	   
	       }
	       
	       catch(Exception e){
	    	   System.out.print("Something went wrong");
	    	   
	       }
	       StringResult mapSource = new StringResult();
	       
	       System.out.println(baseUrl);
	        
	        mapSource.setData(baseUrl);

	        return mapSource;
	    }
		
		
	
}
