package com.project.ecommerce.service.orderItem;

import com.project.ecommerce.entity.OrderItem;
import com.project.ecommerce.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    @Transactional
    public List<OrderItem> findAll() throws Exception {
        try {
            return orderItemRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderItem findById(Long id) throws Exception {
        try {
            Optional<OrderItem> entityOptional = orderItemRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderItem save(OrderItem entity) throws Exception {
        try {
            return orderItemRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderItem update(Long id, OrderItem entity) throws Exception {
        try {
            Optional<OrderItem> entityOptional = orderItemRepository.findById(id);
            OrderItem orderItem = entityOptional.get();
            return orderItemRepository.save(orderItem);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(orderItemRepository.existsById(id)){
                orderItemRepository.deleteById(id);
                return true;
            }
            throw new Exception();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
