package com.Data4Design.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.json.simple.JSONObject;

public class CountryListServiceTest {

    @Test
    public void testGetCountryList() {
        CountryListService test = new CountryListService();
        JSONObject jo = test.getCountryList();
        //System.out.println(jo);
    }

    @Test
    public void testGetCountryCode() {
        CountryListService test = new CountryListService();
        String t = test.getCountryCode("Belgium");
        //System.out.println(t);
    }

    @Test
    public void testGetCountryName() {
        CountryListService test = new CountryListService();
        String t =test.getCountryName("be");
        //System.out.println(t);   
    }

    @Test
    public void testGetCountryListString() {
        CountryListService test = new CountryListService();
        String t = test.getCountryListString();
        System.out.println(t);   
    }

}

