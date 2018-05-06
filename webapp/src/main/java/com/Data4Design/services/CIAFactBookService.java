package com.Data4Design.services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CIAFactBookService implements ICIAFactBookService
{
    public CIAFactBookService()
    {
        try
        {
            JSONParser parser = new JSONParser();
            URL jsonFile = new URL("https://raw.githubusercontent.com/iancoleman/cia_world_factbook_api/master/data/2018-04-30_factbook.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(jsonFile.openStream()));

            totalObject = (JSONObject) parser.parse(reader);
            reader.close();
        }
        catch (ParseException e)
        {
            System.out.println("Trouble parsing data.");
        }
        catch (MalformedURLException e)
        {
            System.out.println("Bad URL");
        }
        catch (IOException e)
        {
            System.out.println("Need to update factbook date.");
        }
    }

    public JSONObject getCIAFactBookCountryObject(String countryCode)
    {
        CountryListService listService = new CountryListService();
        String countryName = listService.getCountryName(countryCode);
        countryName = countryName.toLowerCase();
        countryName = countryName.replaceAll(" ", "_");

        JSONObject countries = (JSONObject) totalObject.get("countries");
        JSONObject countryWanted = (JSONObject) countries.get(countryName);

        return countryWanted;
    }

    private JSONObject totalObject;
}

