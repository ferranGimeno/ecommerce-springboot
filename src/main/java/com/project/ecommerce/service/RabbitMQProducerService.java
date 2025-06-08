package com.project.ecommerce.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToStockQueue(Object message) {
        rabbitTemplate.convertAndSend("stockReductionQueue", message);
    }

    public void sendToBuyQueue(Object message) {
        rabbitTemplate.convertAndSend("buyQueue", message);
    }
}
