package com.Data4Design.services;

import com.Data4Design.results.StringResult;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.validation.constraints.Null;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NaturalResourceService implements INaturalResourceService
{
    public StringResult getNaturalResources(String countryCode)
    {
        StringResult resources = new StringResult();
        try
        {
            CountryListService listService = new CountryListService();
            String countryName = listService.getCountryName(countryCode);
            countryName = countryName.replaceAll(" ", "_");

            JSONParser parser = new JSONParser();
            URL jsonFile = new URL("https://raw.githubusercontent.com/iancoleman/cia_world_factbook_api/master/data/2018-03-26_factbook.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(jsonFile.openStream()));

            JSONObject totalObject = (JSONObject) parser.parse(reader);
            JSONObject countries = (JSONObject) totalObject.get("countries");
            JSONObject countryWanted = (JSONObject) countries.get(countryName);

        }

        catch (ParseException e)
        {
            System.out.println("Trouble parsing data");
        }
        catch (MalformedURLException e)
        {
            System.out.println("Bad URL");
        }
        catch (IOException e)
        {
            System.out.println("Update the factbook URL");
        }
        catch(NullPointerException e)
        {
           System.out.println("Data not available.");
        }

        return null;
    }
}
