package com.springboot.library.repository;

import com.springboot.library.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void testFindByName(){
        List<Author> authors = authorRepository.findByName("John Smith");
        System.out.println(authors);
    }

    @Test
    void testFindAllOrderByNameAsc(){
        List<Author> authors = authorRepository.findAllByOrderByNameAsc();
        System.out.println(authors);
    }

    @Test
    void testFindAllOrderByNameDesc(){
        List<Author> authors = authorRepository.findAllByOrderByNameDesc();
        System.out.println(authors);
    }

    @Test
    void testFindAllDistinctByOrderByName(){
        List<Author> authors = authorRepository.findAllDistinctByOrderByNameAsc();
        System.out.println(authors);
    }

    @Test
    void testFindByNameIgnore(){
        List<Author> authors = authorRepository.findByNameIgnoreCase("JohN SmItH");
        System.out.println(authors);
    }
}
