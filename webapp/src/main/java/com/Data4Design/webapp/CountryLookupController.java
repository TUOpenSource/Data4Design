package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import com.Data4Design.services.*;
import com.Data4Design.results.*;
import com.Data4Design.Implementations.*;
import com.Data4Design.Interfaces.*;
import com.Data4Design.Workflows.Implementations.*;
import com.Data4Design.Workflows.Interfaces.*;
import com.Data4Design.Interfaces.ICountryInfoItemService;
import com.Data4Design.Workflows.Interfaces.IGetCountryInfoWorkflow;


@Controller
@RequestMapping(value = "/country")
public class CountryLookupController {

	private Collection<ICountryInfoItemService> iCountryInfoItemServices = new ArrayList<ICountryInfoItemService>();
	private IGetCountryInfoWorkflow countryInfoWorkflow;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    //@ResponseBody

    public String country_page(Map<String, Object> model, @PathVariable String id) {
    	String str_id = String.valueOf(id);
    	CountryInfo countryInfo = new CountryInfo();
		Country thisCountry = new Country(str_id);


		iCountryInfoItemServices.add(new AnnualPrecipitationServiceCountryInfoItem());
		iCountryInfoItemServices.add(new AnnualTemperatureServiceCountryInfoItem());
		iCountryInfoItemServices.add(new MonthlyTemperatureServiceCountryInfoItem());
		iCountryInfoItemServices.add(new MonthlyPrecipitationServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new CellPenetrationServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new CountryPopulationServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new ElectricityUsageServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new MapServiceCountryInfoItem());
		iCountryInfoItemServices.add(new NaturalResourcesServiceCountryInfoItem());

		CountryListService country_list_service = new CountryListService();
        String country_list = country_list_service.getCountryListString();
		model.put("country_code", str_id);

		model.put("country_list", country_list);
		model.put("country_name", country_list_service.getCountryName(str_id));
		model.put("country_code_3", country_list_service.toISO3(str_id));

    	try {
			countryInfoWorkflow = new GetCountryInfoWorkflow(iCountryInfoItemServices);
			countryInfo = countryInfoWorkflow.GetCountryInfo(thisCountry);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	for(CountryInfoItem c: countryInfo.CountryInfoItems) {
    		model.put(c.Title, c.Value);
		}

        return "country_page";
    }

}
