package com.project.ecommerce.controller;

import com.project.ecommerce.entity.User;
import com.project.ecommerce.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("")
    private ResponseEntity<?> getUsers(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }
    @PostMapping("")
    private ResponseEntity<?> createUser(@RequestBody User user){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.save(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }

}
