package com.project.ecommerce.listener;

import com.project.ecommerce.entity.Item;
import com.project.ecommerce.entity.dto.StockReductionMessage;
import com.project.ecommerce.service.item.ItemServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class StockListener {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @RabbitListener(queues = "stockReductionQueue")
    public void removeStock(StockReductionMessage message) throws Exception {
        try{
            Item itemRetrieved = itemServiceImpl.findById(message.getItem().getId());
            Integer stockToRemove = message.getItem().getQuantity();
            message.getItem().setQuantity(itemRetrieved.getQuantity() - stockToRemove);
            //TODO: is not removing the stock in Item table
            itemServiceImpl.update(message.getItem().getId(), message.getItem());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
