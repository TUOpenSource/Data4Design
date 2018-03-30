package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import com.Data4Design.services.*;

@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        CountryListService country_list_service = new CountryListService();
        String country_list = country_list_service.getCountryListString();

        model.put("country_list", country_list);
        
        return "index";
    }

}