package com.Data4Design.Implementations;

import java.net.HttpURLConnection;
import java.net.URL;

import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Implementations.Country;
import com.Data4Design.Workflows.Implementations.CountryInfoItem;


public class MapServiceCountryInfoItem implements ICountryInfoItemService {

	@Override
<<<<<<< HEAD
	public CountryInfoItem GetCountryInfoItem(String countryName) {
		CountryListService countryList = new CountryListService();
		   String CountryName = countryList.getCountryName(countryName);
		   String oldApiKey = "AIzaSyBwhOcDvZryXjm3ZSUxHHEHeRQflJH5ctc";

	       String baseUrl = "https://maps.googleapis.com/maps/api/js?key=AIzaSyCkQwa9T2l2h0txTwEjunyYBS-KLLOX17k&callback=initMap";
	       
	    //    try {
	    // 	       URL url = new URL(baseUrl);
	    //        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    //        connection.setRequestMethod("GET");
	           
	    	   
	    //    }
	       
	    //    catch(Exception e){
	    // 	   System.out.print("Something went wrong");
	    	   
	    //    }
	       
=======
	public CountryInfoItem GetCountryInfoItem(Country thisCountry) {
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
>>>>>>> 53a66afd9c5cc984ec6290e75c2e07dd847321b8
	        
	    CountryInfoItem countryInfoItem = new CountryInfoItem();
	    countryInfoItem.setTitle("map");
		//String str = DecimalFormat.getNumberInstance().format(rainfall);
		//str = new DecimalFormat("#.0#").format(rainfall);
		countryInfoItem.setValue(baseUrl);
		return countryInfoItem;
	}

}
