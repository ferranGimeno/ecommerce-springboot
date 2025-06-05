package com.project.inventory_management.service;

import com.project.inventory_management.entity.Item;
import com.project.inventory_management.entity.Order;
import com.project.inventory_management.repository.ItemRepository;
import com.project.inventory_management.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrderService implements BaseService<Order>{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;

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

    /*public List<Order> buyItems(List<Item> itemList) throws Exception {
        try{
            if(checkStock(itemList)){
                return
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }*/

    public boolean checkStock(List<Item> itemList) {
        for (int i = 0; i < itemList.size(); i++){
            if(itemRepository.findById(itemList.get(i).getId()).isEmpty()) return false;
        }
        return true;
    }
}
