package com.project.ecommerce.service.user;

import com.project.ecommerce.entity.User;
import com.project.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> findAll() throws Exception {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User findById(Long id) throws Exception {
        try {
            Optional<User> entityOptional = userRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User save(User entity) throws Exception {
        try {
            return userRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User update(Long id, User entity) throws Exception {
        try {
            Optional<User> entityOptional = userRepository.findById(id);
            User user = entityOptional.get();
            return userRepository.save(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(userRepository.existsById(id)){
                userRepository.deleteById(id);
                return true;
            }
            throw new Exception();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
