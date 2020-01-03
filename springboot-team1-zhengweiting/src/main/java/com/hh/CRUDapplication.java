package com.hh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class CRUDapplication {
    public static void main(String[] args) {
        SpringApplication.run(CRUDapplication.class,args);
    }
}
