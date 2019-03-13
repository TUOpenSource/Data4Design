package com.Data4Design.services;

import org.json.simple.JSONObject;
import com.Data4Design.results.LongResult;

public class CellPenetrationService implements ICellPenetrationService
{
    public LongResult getCellPenetration(String countryCode)
    {
        LongResult cellpen= new LongResult();

        CIAFactBookService factBook = new CIAFactBookService();
        JSONObject country = factBook.getCIAFactBookCountryObject(countryCode);
        try
        {
            JSONObject dataObject = (JSONObject) country.get("data");
            JSONObject communications = (JSONObject) dataObject.get("communications");
            JSONObject telephoneObject = (JSONObject) communications.get("telephones");
            JSONObject mobile = (JSONObject) telephoneObject.get("mobile_cellular");
            cellPenetration = (long) mobile.get("subscriptions_per_one_hundred_inhabitants");
        }

        catch(NullPointerException e)
        {
            System.out.println("Data not available.");
            cellPenetration = -1;
        }

        cellpen.setData(cellPenetration);
        return cellpen;
    }
    private long cellPenetration;
}

