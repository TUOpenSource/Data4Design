package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class WelcomeControllerJsp {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/welcomejsp")
    public String welcomeJSP(Map<String, Object> model) {
        RestTemplate restTemplate = new RestTemplate();
        QuoteRestExample quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", QuoteRestExample.class);
        model.put("message", this.message);
        model.put("rest_response", quote.toString());
        return "welcome";
    }

}