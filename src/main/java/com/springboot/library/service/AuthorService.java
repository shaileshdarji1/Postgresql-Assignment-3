package com.springboot.library.service;

import com.springboot.library.entity.Author;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {

    public Author saveAuthor(Author author);

    public Author updateAuthor(Long id, Author updateAuthor);

    public Author getAuthor(Long id);

    public List<Author> getAllAuthor();

    public String deleteAuthor(Long id);

    public Page<Author>  findAuthorPageWise(Integer offset,Integer size,String field);
}
