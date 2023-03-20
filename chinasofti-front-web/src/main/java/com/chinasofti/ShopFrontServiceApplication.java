package com.chinasofti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = "com.chinasofti.mapper")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
 public class ShopFrontServiceApplication {
 public static void main(String[] args) {
         SpringApplication.run(ShopFrontServiceApplication.class,args);
         }
 }