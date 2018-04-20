package com.Data4Design.services;

import com.Data4Design.results.StringResult;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class NaturalResourceService implements INaturalResourceService
{
    public StringResult getNaturalResources(String countryCode)
    {
        StringResult resources = new StringResult();
        CIAFactBookService factBook = new CIAFactBookService();
        JSONObject country = factBook.getCIAFactBookCountryObject(countryCode);

        try
        {
            JSONObject data = (JSONObject) country.get("data");
            JSONObject geography = (JSONObject) data.get("geography");
            JSONObject naturalResources = (JSONObject) geography.get("natural_resources");
            JSONArray types = (JSONArray) naturalResources.get("resources");
            String [] arr = new String [types.size()];
            String result = "";
            for(int i = 0; i < types.size(); i++)
            {
                result += (String)types.get(i);
                if(types.size() > (i+1))
                {
                    result += ", ";
                }

            }
            resources.setData(result);
            return resources;
        }

        catch(NullPointerException e)
        {
           System.out.println("Data not available.");
        }

        return null;
    }
}
