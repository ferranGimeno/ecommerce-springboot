package com.project.ecommerce.service.item;

import com.project.ecommerce.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll() throws Exception;
    public Item findById(Long id) throws Exception;
    public Item save(Item entity) throws Exception;
    public Item update(Long id, Item entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
