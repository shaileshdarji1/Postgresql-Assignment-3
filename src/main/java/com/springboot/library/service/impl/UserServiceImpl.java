package com.springboot.library.service.impl;

import com.springboot.library.entity.User;
import com.springboot.library.exception.UserNotFoundException;
import com.springboot.library.repository.UserRepository;
import com.springboot.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updateUser) {
        if (userRepository.existsById(id)) {
            updateUser.setId(id);
            return userRepository.save(updateUser);
        } else {
            throw new UserNotFoundException("User Not Found !");
        }
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found !"));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User Deleted Successfully";
        } else {
            throw new UserNotFoundException("User Not Found !");
        }
    }
}
