package com.springboot.library.controller;

import com.springboot.library.entity.UserView;
import com.springboot.library.service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-view")
public class UserViewController {

    @Autowired
    UserViewService userViewService;

    @GetMapping
    public List<UserView> findAllUserView(){
        return userViewService.findAllUserView();
    }
}
