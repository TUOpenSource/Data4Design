package com.Data4Design.services;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public interface ICountryListService {

    public JSONObject getCountryList();
    public String getCountryListString();
    public String getCountryCode(String name);
    public String getCountryName(String code);
}
