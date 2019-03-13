package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import com.Data4Design.services.*;
import com.Data4Design.results.*;
import com.Data4Design.Implementations.*;
import com.Data4Design.Interfaces.*;
import com.Data4Design.Workflows.Implementations.*;
import com.Data4Design.Workflows.Interfaces.*;


@Controller
@RequestMapping(value="/country")
public class CountryLookupController {

    // inject via application.properties
    //@Value("${index.message:test}")
    //private String message = "Hello World";
	
	private Collection<ICountryInfoItemService> iCountryInfoItemServices = new ArrayList<ICountryInfoItemService>();
	private IGetCountryInfoWorkflow countryInfoWorkflow;
	


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public String country_page(Map<String, Object> model, @PathVariable String id) {
    	/*CountryInfo countryInfo = new CountryInfo();
    	String str_id = String.valueOf(id);
    	CountryListService country_list_service = new CountryListService();
    	String country_name = country_list_service.getCountryName(str_id);
        String iso_3_str = country_list_service.toISO3(str_id);
    	
    	iCountryInfoItemServices.add(new AnnualPrecipitationServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new AnnualTemperatureServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new CellPenetrationServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new CountryPopulationServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new ElectricityUsageServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new MapServiceCountryInfoItem());
    	iCountryInfoItemServices.add(new NaturalResourcesServiceCountryInfoItem());
    	
    	try {
			countryInfoWorkflow = new GetCountryInfoWorkflow(iCountryInfoItemServices);
			countryInfo = countryInfoWorkflow.GetCountryInfo(str_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	for(CountryInfoItem c: countryInfo.CountryInfoItems) {
    		model.put(c.Title, c.Value);
    	}
    	*/
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        //String Cheese if you please
        String str_id = String.valueOf(id);
        MapService mapService = new MapService();
        
        //Me Getters YO Ho Yo HO
        ElectricityUsageService electricity_service = new ElectricityUsageService();
        NumberResult electricity_usage = electricity_service.getElectricityUsage(str_id);
        CountryPopulationService population_service = new CountryPopulationService();
        CellPenetrationService cell_penetration = new CellPenetrationService();
        AnnualPrecipitationServiceCountryInfoItem yearlyRainService = new AnnualPrecipitationServiceCountryInfoItem();
        //AnnualTemperatureService yearlyTempService = new AnnualTemperatureService();
        ICountryInfoItemService yearlyTempService = new AnnualTemperatureServiceCountryInfoItem();
        LongResult population = population_service.getPopulation(str_id);
        CountryListService country_list_service = new CountryListService();
        NaturalResourceService naturalResourceService = new NaturalResourceService();
        String country_name = country_list_service.getCountryName(str_id);
        String iso_3_str = country_list_service.toISO3(str_id);
        String cellpen = String.format("%d", cell_penetration.getCellPenetration(str_id).getData());
        String natural_resources = naturalResourceService.getNaturalResources(str_id).getData();
        //Me Setters Yee Har Yee Har
        String rainfall = yearlyRainService.GetCountryInfoItem(iso_3_str).getValue();
        String temperature = yearlyTempService.GetCountryInfoItem(iso_3_str).Value;
        model.put("yearly_rainfall", rainfall);
        model.put("yearly_temperature",temperature);
        model.put("map",mapService.getMap(str_id).getData());
        model.put("electricity_usage", electricity_usage.toString());
        model.put("population", population.toString());
        model.put("cell_penetration", cellpen);
        model.put("country_code", str_id);
        model.put("country_code_3", iso_3_str);
        model.put("country_name", country_name);
        model.put("natural_resources", natural_resources);
        
        //This chooses the jsp to grab
        return "country_page";
    }

}