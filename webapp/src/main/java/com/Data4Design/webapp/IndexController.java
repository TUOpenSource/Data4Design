package com.Data4Design.webapp;

import java.util.Map;

import com.Data4Design.services.CountryListService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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