package com.Data4Design.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import com.Data4Design.results.LongResult;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * Makes a call to World Bank API to get the population of a specified 
 * country. Whittles JSON arrays down to the population value. Needs to return
 * some form of NumberResult, but NumberResult doesn't currently handle longs....
 */
public class ElectricityUsageService implements IElectricityUsageService {
    
    @Override
    public LongResult getElectricityUsage(String countryCode) {
        String dateParam = "date=2016:2016&format=json"; 
        //String uri = String.format("https://api.worldbank.org/v2/countries/%s/indicators/SP.POP.TOTL?%s", countryCode, dateParam);
        String uri = String.format("http://api.worldbank.org/v2/countries/$s/indicators/EG.ELC.ACCS.ZS?format=json&MRV=1", countryCode);
        JSONParser parser = new JSONParser();
        LongResult electricityUsage = new LongResult();
        long electricity = 0;
        
        try {
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        BufferedReader json = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        JSONArray jsonArray = (JSONArray) parser.parse(json);
        JSONArray innerJsonArray = (JSONArray) jsonArray.get(1);
        JSONObject finallyAnObject = (JSONObject) innerJsonArray.get(0);
        
        electricity = (Long) finallyAnObject.get("value"); // need a Result to handle Longs!!!!!!!
        System.out.println("Electricity Usage of "+countryCode+" = "+electricity);
        electricityUsage.setData(electricity);
        //NumberResult.data = population ---> how to pass values to results when there isn't a
        // constructor or a set method? NumberResult.data is protected (default access modifier)
                
        json.close();
        
        }
        
        catch (Exception e) {
            System.out.println("ERROR: "+e);
        }

        return electricityUsage;
    }

}
