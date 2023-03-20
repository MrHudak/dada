package com.chinasofti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ChinasoftiEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChinasoftiEurekaServerApplication.class, args);
    }

}
