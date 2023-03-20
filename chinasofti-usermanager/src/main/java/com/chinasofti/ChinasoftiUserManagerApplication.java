package com.chinasofti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.chinasofti.mapper")
public class ChinasoftiUserManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChinasoftiUserManagerApplication.class,args);
    }
}
