package com.springboot.library.service;

import com.springboot.library.entity.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserViewService {
    public List<UserView> findAllUserView();
}
