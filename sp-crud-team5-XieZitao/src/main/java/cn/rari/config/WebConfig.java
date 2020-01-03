package cn.rari.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册视图控制器
        // url为："/crud"
        // 视图名为："crud"
        // 对应页面：templates/crud.html
        registry.addViewController("/crud").setViewName("crud");
    }
}
