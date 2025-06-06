package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Item;
import com.project.ecommerce.entity.Order;
import com.project.ecommerce.service.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/buy")
public class BuyController {
    @Autowired
    OrderServiceImpl orderServiceImpl;

    @PostMapping("")
    public ResponseEntity<?> buyItems(@RequestBody List<Item> itemList){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(orderServiceImpl.buyItems(itemList));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
