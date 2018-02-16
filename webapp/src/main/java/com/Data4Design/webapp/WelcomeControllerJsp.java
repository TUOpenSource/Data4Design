package com.Data4Design.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class WelcomeControllerJsp {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/welcomejsp")
    public String welcomeJSP(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

}