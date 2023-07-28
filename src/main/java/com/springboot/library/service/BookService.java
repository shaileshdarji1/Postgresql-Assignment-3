package com.springboot.library.service;

import com.springboot.library.entity.Book;

import java.util.List;

public interface BookService {
    public Book saveBook(Book book);

    public Book updateBook(Long id, Book updateBook);

    public Book getBook(Long id);

    public List<Book> getAllBook();

    public String deleteBook(Long id);
}
