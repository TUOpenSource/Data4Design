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
	       
	        
	        CountryInfoItem countryInfoItem = new CountryInfoItem();
			countryInfoItem.setTitle("map");
			//String str = DecimalFormat.getNumberInstance().format(rainfall);
			//str = new DecimalFormat("#.0#").format(rainfall);
			countryInfoItem.setValue(baseUrl);
			return countryInfoItem;
	}

}
