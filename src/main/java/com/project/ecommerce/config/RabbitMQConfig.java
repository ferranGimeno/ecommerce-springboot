package com.project.ecommerce.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue stockReductionQueue() {
        return new Queue("stockReductionQueue", true);
    }

}
