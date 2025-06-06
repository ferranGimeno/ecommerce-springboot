package com.project.ecommerce.service.order;

import com.project.ecommerce.entity.Item;
import com.project.ecommerce.entity.Order;
import com.project.ecommerce.repository.ItemRepository;
import com.project.ecommerce.repository.OrderRepository;
import jakarta.transaction.Transactional;

import org.aspectj.weaver.ast.Or;
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

    public List<Order> buyItems(List<Item> itemList) throws Exception {
        try{
            List<Order> orderList = new ArrayList<>();
            for (Item item : itemList) {
                if (checkStock(item)) {
                    Order order = new Order();
                    order.setItemId(item.getId());
                    order.setQuantity(item.getQuantity());
                    //TODO: pending to retrieve userId
                    order.setUserId(1L);
                    orderRepository.save(order);
                    orderList.add(order);
                }else{
                    throw new Exception("There are items with no enough stock");
                }
            }
            return orderList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean checkStock(Item item) {
        Optional<Item> itemRetrieved = itemRepository.findById(item.getId());
        if(itemRetrieved.get().getQuantity() < item.getQuantity()){
            return false;
        }
        return true;
    }
}
