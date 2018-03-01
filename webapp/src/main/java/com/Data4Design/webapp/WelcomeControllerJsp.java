package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WelcomeControllerJsp {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    private static final Logger log = LoggerFactory.getLogger(WebappApplication.class);

    @RequestMapping("/welcomejsp")
    public String welcomeJSP(Map<String, Object> model) {
        RestTemplate restTemplate = new RestTemplate();
        QuoteRestExample quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", QuoteRestExample.class);
        String wb_resp = restTemplate.getForObject("http://api.worldbank.org/v2/countries/all/indicator/EG.ELC.ACCS.ZS?format=json", String.class);
        model.put("message", this.message);
        model.put("rest_response", wb_resp);
        log.info(wb_resp);
        return "welcome";
    }

}