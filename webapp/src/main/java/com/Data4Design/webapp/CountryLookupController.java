package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import com.Data4Design.services.*;
import com.Data4Design.results.*;

@Controller
@RequestMapping(value="/country")
public class CountryLookupController {

    // inject via application.properties
    //@Value("${index.message:test}")
    //private String message = "Hello World";


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public String country_page(Map<String, Object> model, @PathVariable String id) {
        //String Cheese if you please
        String str_id = String.valueOf(id);
        MapService mapService = new MapService();
        
        //Me Getters YO Ho Yo HO
        ElectricityUsageService electricity_service = new ElectricityUsageService();
        NumberResult electricity_usage = electricity_service.getElectricityUsage(str_id);
        CountryPopulationService population_service = new CountryPopulationService();
        CellPenetrationService cell_penetration = new CellPenetrationService();
        AnnualPrecipitationService yearlyRainService = new AnnualPrecipitationService();
        AnnualTemperatureService yearlyTempService = new AnnualTemperatureService();
        LongResult population = population_service.getPopulation(str_id);
        CountryListService country_list_service = new CountryListService();
        String country_name = country_list_service.getCountryName(str_id);
        String iso_3_str = country_list_service.toISO3(str_id);
        String cellpen = String.format("%d", cell_penetration.getCellPenetration(str_id).getData());
        //Me Setters Yee Har Yee Har
        String rainfall = String.format("%f", yearlyRainService.getAnnualPrecipitation(iso_3_str).getData());
        String temperature = String.format("%f",yearlyTempService.getAverageAnnualTemperature(iso_3_str).getData());
        model.put("yearly_rainfall", rainfall);
        model.put("yearly_temperature",temperature);
        model.put("map",mapService.getMap(str_id).getData());
        model.put("electricity_usage", electricity_usage.toString());
        model.put("population", population.toString());
        model.put("cell_penetration", cellpen);
        model.put("country_code", str_id);
        model.put("country_code_3", iso_3_str);
        model.put("country_name", country_name);
        
        //This chooses the jsp to grab
        return "country_page";
    }

}