package com.project.ecommerce.service.order;

import com.project.ecommerce.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAll() throws Exception;
    public Order findById(Long id) throws Exception;
    public Order save(Order entity) throws Exception;
    public Order update(Long id, Order entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
