package com.chep.spring_security_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Spring boot security provides default login credentials as; username-user
// password-generated and displayed on the console log

// to generate your own users it is done by the help of application properties

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    public String getDemo(){
        return("<h1> Spring Boot Security Test Successful</h1>");
    }
    @GetMapping("/one")
    public String getDemo1(){
        return("<h1> Spring Boot Security Test ONE Successful</h1>");
    }

    @GetMapping("/two")
    public String getDemo2(){
        return("<h1> Spring Boot Security Test TWO Successful</h1>");
    }

    @GetMapping("/three")
    public String getDemo3(){
        return("<h1> Spring Boot Security Test THREE Successful</h1>");
    }
}
