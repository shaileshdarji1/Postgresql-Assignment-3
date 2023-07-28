package com.springboot.library.service.impl;

import com.springboot.library.entity.Author;
import com.springboot.library.exception.AuthorNotFoundException;
import com.springboot.library.repository.AuthorRepository;
import com.springboot.library.service.AuthorService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author updateAuthor) {
        if (authorRepository.existsById(id)) {
            updateAuthor.setId(id);
            return authorRepository.save(updateAuthor);
        } else {
            throw new AuthorNotFoundException("Auhtor Not Found !");
        }

    }

    @Override
    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author Not Found"));
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public String deleteAuthor(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return "Author Deleted Successfully";
        } else {
            throw new AuthorNotFoundException("Author Not Found!");
        }
    }

    @Override
    public Page<Author> findAuthorPageWise(Integer offset, Integer size,String field) {
        return authorRepository.findAll(PageRequest.of(offset,size).withSort(Sort.by(Sort.Direction.ASC,field)));
    }
}
