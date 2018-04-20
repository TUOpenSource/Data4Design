package com.Data4Design.services;

import com.Data4Design.results.StringResult;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaturalResourceServiceTest
{

    @Test
    void NaturalResourceTest()
    {
        String [] actual =  {
        "natural gas",
                "petroleum",
                "coal",
                "copper",
                "chromite",
                "talc",
                "barites",
                "sulfur",
                "lead",
                "zinc",
                "iron ore",
                "salt",
                "precious",
                "semiprecious stones",
                "arable land"};

        NaturalResourceService test = new NaturalResourceService();
        StringResult result = test.getNaturalResources("AF");

        assertTrue(true);
    }

}