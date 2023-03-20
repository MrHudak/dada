package com.chinasofti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.chinasofti.mapper")
public class ChinasoftiManagerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChinasoftiManagerWebApplication.class,args);
    }
}
