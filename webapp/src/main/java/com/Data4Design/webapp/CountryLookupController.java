package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import com.Data4Design.services;

@Controller
public class CountryLookupController {

    // inject via application.properties
    //@Value("${index.message:test}")
    //private String message = "Hello World";

    @RequestMapping(value = "/country/{id}", method = GET)
    @ResponseBody
    public String index(Map<String, Object> model) {
        //String Cheese if you please
        this.id = id.toString();
        ElectricityUsageService electricity_service = new ElectricityUsageService();
        this.electricity_usage = electricity_service.getElectricityUsage(this.id);
        CountryPopulationService population_service = new CountryPopulationService();
        this.population = population_service.getPopulation(this.id);
        model.put("electricity_usage", this.electricity_usage);
        model.put("population", this.population);
        model.put("country_code", this.id);
        //This chooses the jsp to grab
        return "country_page";
    }

}