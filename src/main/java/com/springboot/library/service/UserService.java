package com.springboot.library.service;

import com.springboot.library.entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public User updateUser(Long id, User updateUser);

    public User getUser(Long id);

    public List<User> getAllUser();

    public String deleteUser(Long id);
}
