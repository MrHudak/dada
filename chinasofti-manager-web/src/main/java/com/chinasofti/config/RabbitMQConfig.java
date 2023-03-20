package com.chinasofti.config;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /**
     * 定义topic交换机
     */
    @Bean
    public TopicExchange messageTopicExchange(){
        return (TopicExchange) ExchangeBuilder.topicExchange("CHINASOFTI_PRODUCT_EXCHANGE")
                .durable(true).build();
    }
}