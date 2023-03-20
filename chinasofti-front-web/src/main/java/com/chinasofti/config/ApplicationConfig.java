package com.chinasofti.config;

import com.chinasofti.interceptor.MvcInterceptor;
import com.chinasofti.interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {

        @Autowired
private MvcInterceptor mvcInterceptor;

    @Autowired
 private UserLoginInterceptor userLoginInterceptor;
/**
 * 配置拦截器
 */
        @Override
public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(mvcInterceptor)
                .excludePathPatterns(
                "/**/css/**",
                "/**/js/**",
                "/**/images/**")
                .addPathPatterns("/**");
        //添加用户拦截器
            registry.addInterceptor(userLoginInterceptor).addPathPatterns("/order/**");
         }
 /**
  * 配置资源处理器
  *
  */
         @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("/static/**")
         .addResourceLocations("classpath:/static/");
         }
 /**
  * 设置系统编码UTF-8
  */
         @Bean
 public HttpMessageConverter<String> responseBodyConverter(){
         StringHttpMessageConverter converter = new
                StringHttpMessageConverter(Charset.forName("UTF-8"));
         return converter;
         }
 }