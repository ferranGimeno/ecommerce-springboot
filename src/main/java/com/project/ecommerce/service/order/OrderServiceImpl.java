package com.project.ecommerce.service.order;

import com.project.ecommerce.entity.Order;
import com.project.ecommerce.repository.ItemRepository;
import com.project.ecommerce.repository.OrderRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
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

    public List<Order> buyItems(List<Order> orderList) throws Exception {
        try{
            for (int i = 0; i < orderList.size(); i++) {
                //TODO check stock
                //if (checkStock(orderList.get(i))) {}
                orderRepository.save(orderList.get(i));
            }
            return orderList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean checkStock(Order order) {
        if(true){
            return true;
        }
        return false;
    }
}
