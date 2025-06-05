package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Item;
import com.project.ecommerce.service.item.ItemServiceImpl;
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
    ItemServiceImpl itemServiceImpl;

    @PostMapping("")
    public ResponseEntity<?> buyItems(@RequestBody List<Item> itemList){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(itemList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }


}
