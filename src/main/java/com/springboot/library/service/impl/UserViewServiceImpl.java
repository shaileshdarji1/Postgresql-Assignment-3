package com.springboot.library.service.impl;

import com.springboot.library.entity.UserView;
import com.springboot.library.repository.UserViewRepository;
import com.springboot.library.service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserViewServiceImpl implements UserViewService {

    @Autowired
    UserViewRepository userViewRepository;

    @Override
    @Transactional
    public List<UserView> findAllUserView() {
        return userViewRepository.findAll();
    }
}
