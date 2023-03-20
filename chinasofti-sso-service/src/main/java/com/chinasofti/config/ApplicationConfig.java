package com.chinasofti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;

/**
  * 通用系统配置
  */
 @Configuration
 public class ApplicationConfig implements WebMvcConfigurer {

         /**
  * 设置系统编码UTF-8
  */
         @Bean
 public HttpMessageConverter<String> responseBodyConverter(){
         StringHttpMessageConverter converter = new
                StringHttpMessageConverter(Charset.forName("UTF-8"));
         return converter;
         }
 /**
  * 配置通用跨域
  */
         @Override
 public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")
         //.allowedOrigins("/*")
         .allowedOriginPatterns("*")
         .allowedMethods("POST","GET","PUT","OPTION","DELETE")
         .allowedHeaders("/*")
         .maxAge(3600)
         .allowCredentials(true);
         }
 }