package com.lgm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册一个视图控制器：url为："/study1"，视图名为："vue1"--对应页面：templates/vue1.html
        registry.addViewController("/study1").setViewName("vue1");
        registry.addViewController("/crud").setViewName("crud");
    }
}
