package com.zx.office;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zx.office.dao")
@ComponentScan(basePackages = {"com.zx.office.controller", "com.zx.office.service"})
public class OfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class, args);
    }

}
