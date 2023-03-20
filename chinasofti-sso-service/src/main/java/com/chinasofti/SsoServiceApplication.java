package com.chinasofti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(basePackages = "com.chinasofti.mapper")
@EnableEurekaClient
public class SsoServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(SsoServiceApplication.class,args);
    }
}
