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
        ElectricityUsageService electricity_service = new ElectricityUsageService();
        LongResult electricity_usage = electricity_service.getElectricityUsage(str_id);
        CountryPopulationService population_service = new CountryPopulationService();
        LongResult population = population_service.getPopulation(str_id);
        model.put("electricity_usage", electricity_usage.toString());
        model.put("population", population.toString());
        model.put("country_code", str_id);
        //This chooses the jsp to grab
        return "country_page";
    }

}