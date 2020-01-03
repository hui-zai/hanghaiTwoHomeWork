package com.cwz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: springboot-team7-chengweizhao
 * @Package: com.cwz.config
 * @ClassName: WebConfig
 * @Author: 程伟钊
 * @Description: 配置文件
 * @Date: 2020/1/1 22:32
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/crud").setViewName("crud");
    }
}
