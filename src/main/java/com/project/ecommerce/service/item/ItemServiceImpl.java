package com.project.ecommerce.service.item;

import com.project.ecommerce.entity.Item;
import com.project.ecommerce.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public List<Item> findAll() throws Exception {
        try {
            return itemRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Item findById(Long id) throws Exception {
        try {
            Optional<Item> entityOptional = itemRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Item save(Item entity) throws Exception {
        try {
            return itemRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Item update(Long id, Item entity) throws Exception {
        try {
            Optional<Item> entityOptional = itemRepository.findById(id);
            Item item = entityOptional.get();
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(itemRepository.existsById(id)){
                itemRepository.deleteById(id);
                return true;
            }
            throw new Exception();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
