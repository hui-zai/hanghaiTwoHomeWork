package com.lx.vuecrud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lx.vuecrud.mapper")
public class VuecrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuecrudApplication.class, args);
    }

}
