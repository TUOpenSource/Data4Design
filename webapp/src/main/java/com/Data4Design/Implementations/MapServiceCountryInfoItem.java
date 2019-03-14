package com.Data4Design.Implementations;

import java.net.HttpURLConnection;
import java.net.URL;

import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Implementations.CountryInfoItem;
import com.Data4Design.services.CountryListService;

public class MapServiceCountryInfoItem implements ICountryInfoItemService {

	@Override
	public CountryInfoItem GetCountryInfoItem(String countryName) {
		CountryListService countryList = new CountryListService();
		   String CountryName = countryList.getCountryName(countryName);
		   String apiKey = "AIzaSyBwhOcDvZryXjm3ZSUxHHEHeRQflJH5ctc";

	       String baseUrl = "https://maps.googleapis.com/maps/api/staticmap?center=";
	       baseUrl+=CountryName;
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
	       
	        
	        CountryInfoItem countryInfoItem = new CountryInfoItem();
			countryInfoItem.setTitle("map");
			//String str = DecimalFormat.getNumberInstance().format(rainfall);
			//str = new DecimalFormat("#.0#").format(rainfall);
			countryInfoItem.setValue(baseUrl);
			return countryInfoItem;
	}

}
