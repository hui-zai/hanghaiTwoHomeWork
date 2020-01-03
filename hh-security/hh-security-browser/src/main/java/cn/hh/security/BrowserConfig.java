package cn.hh.security;

import cn.hh.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 浏览器安全配置类
 */
@Configuration
@EnableWebSecurity
public class BrowserConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public SecurityProperties securityProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        httpBasic()：修改认证方式为：http基本认证
        formLogin()：表单认证
        authorizeRequests()：身份认证
        anyRequest()：所有请求
        authenticated()：都需要认证
         */
        http
                .formLogin()
                //.loginPage("/siginIn.html")
                .loginPage(securityProperties.getBrowser().getLoginPage()).permitAll()
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests()
                .antMatchers("/siginIn.html","/authentication/form").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
