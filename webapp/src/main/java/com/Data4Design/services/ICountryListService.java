package com.Data4Design.services;

import org.json.simple.JSONObject;

public interface ICountryListService {

    public JSONObject getCountryList();

    public String getCountryListString();

    public String getCountryCode(String name);

    public String getCountryName(String code);

    public String toISO3(String iso2);
}
