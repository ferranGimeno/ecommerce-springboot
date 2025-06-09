package com.project.ecommerce.service.order;

import com.project.ecommerce.entity.Item;
import com.project.ecommerce.entity.Order;
import com.project.ecommerce.entity.OrderItem;
import com.project.ecommerce.repository.OrderRepository;
import com.project.ecommerce.service.item.ItemServiceImpl;
import com.project.ecommerce.service.orderItem.OrderItemServiceImpl;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @Autowired
    private OrderItemServiceImpl orderItemServiceImpl;

    @Override
    @Transactional
    public List<Order> findAll() throws Exception {
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Order findById(Long id) throws Exception {
        try {
            Optional<Order> entityOptional = orderRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Order save(Order entity) throws Exception {
        try {
            return orderRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Order update(Long id, Order entity) throws Exception {
        try {
            Optional<Order> entityOptional = orderRepository.findById(id);
            Order order = entityOptional.get();
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(orderRepository.existsById(id)){
                orderRepository.deleteById(id);
                return true;
            }
            throw new Exception();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Order buyItems(List<Item> itemList) throws Exception {
        try{
            //Check stock for entire order, if there is some item not possible, return error
            if (checkStock(itemList)) {
                Order order = new Order();
                //TODO: pending to retrieve userId
                order.setUserId(1L);
                orderRepository.save(order);
                for (Item item : itemList) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setItem(item);
                    orderItem.setOrder(order);
                    orderItem.setQuantity(item.getQuantity());
                    orderItemServiceImpl.save(orderItem);

                    //TODO: enable RabbitMQ
                    //Send to RabbitMQ queue
                    //stockReductionMessage msg = new StockReductionMessage(item);
                    //rabbitMQProducerService.sendToStockQueue(msg);
                }
                return order;
            }else{
                throw new Exception("There are items with not enough stock");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean checkStock(List<Item> itemList) throws Exception {
        try {
            for (Item item : itemList) {
                Item itemRetrieved = itemServiceImpl.findById(item.getId());
                if (itemRetrieved.getQuantity() < item.getQuantity()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void removeStock(Item item) throws Exception {
        try{
            Item itemRetrieved = itemServiceImpl.findById(item.getId());
            Integer stockToRemove = item.getQuantity();
            item.setQuantity(itemRetrieved.getQuantity() - stockToRemove);
            //TODO: is not removing the stock in Item table
            itemServiceImpl.update(item.getId(), item);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
