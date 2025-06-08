package com.project.ecommerce.service.orderItem;

import com.project.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderItemService {
    public List<OrderItem> findAll() throws Exception;
    public OrderItem findById(Long id) throws Exception;
    public OrderItem save(OrderItem entity) throws Exception;
    public OrderItem update(Long id, OrderItem entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
