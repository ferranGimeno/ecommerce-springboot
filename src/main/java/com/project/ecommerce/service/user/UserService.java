package com.project.ecommerce.service.user;

import com.project.ecommerce.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll() throws Exception;
    public User findById(Long id) throws Exception;
    public User save(User entity) throws Exception;
    public User update(Long id, User entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
