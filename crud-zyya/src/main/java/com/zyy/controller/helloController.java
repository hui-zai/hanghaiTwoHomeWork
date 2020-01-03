package com.zyy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回json
public class helloController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Spring boot，您好！";
    }
}
