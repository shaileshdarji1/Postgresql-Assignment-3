package com.springboot.library.repository;

import com.springboot.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByName(String name);

    List<Author> findAllByOrderByNameAsc();

    List<Author> findAllByOrderByNameDesc();

    List<Author> findAllDistinctByOrderByNameAsc();

    List<Author> findByNameIgnoreCase(String name);
}
