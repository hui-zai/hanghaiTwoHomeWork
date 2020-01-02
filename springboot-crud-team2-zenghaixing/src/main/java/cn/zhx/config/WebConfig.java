package cn.zhx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.testng.annotations.ITestOrConfiguration;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册一个视图控制器：url为："/study"，视图名为："xing"--对应页面：paidaxing/xing.html
        registry.addViewController("/crud").setViewName("hai");
    }
}
