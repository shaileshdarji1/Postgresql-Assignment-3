package com.springboot.library.repository;

import com.springboot.library.entity.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserViewRepository extends JpaRepository<UserView,Integer> {
}
