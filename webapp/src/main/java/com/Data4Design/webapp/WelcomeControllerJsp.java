package com.Data4Design.webapp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeControllerJsp {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    private static final Logger log = LoggerFactory.getLogger(WebappApplication.class);

    @RequestMapping("/welcomejsp")
    public String welcomejsp(Map<String, Object> model) {
        return "welcome";
    }

}