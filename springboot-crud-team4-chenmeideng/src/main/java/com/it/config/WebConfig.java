package com.it.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //注册一个视图控制器，url为:(urlPath:"")
        registry.addViewController("/crud").setViewName("crud");
    }
}
