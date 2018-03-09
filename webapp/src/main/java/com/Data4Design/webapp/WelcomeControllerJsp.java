package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class WelcomeControllerJsp {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    private static final Logger log = LoggerFactory.getLogger(WebappApplication.class);

    @RequestMapping("/welcomejsp")
    public String welcomejsp(Map<String, Object> model) {
        RestTemplate restTemplate = new RestTemplate();
        //QuoteRestExample quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", QuoteRestExample.class);
        //String wb_resp = restTemplate.getForObject("http://api.worldbank.org/v2/countries/br/indicators/EG.ELC.ACCS.ZS?format=json&MRV=1", String.class);
        //String wb_resp_str = wb_resp;
        //model.put("message", wb_resp.page);
        //model.put("rest_response", quote.toString());
        //model.put("rest_response", wb_resp_str);
        //log.info(wb_resp);
        return "welcome";
    }

}