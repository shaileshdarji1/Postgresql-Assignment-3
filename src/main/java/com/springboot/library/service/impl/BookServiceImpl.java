package com.springboot.library.service.impl;

import com.springboot.library.entity.Book;
import com.springboot.library.exception.BookNotFoundException;
import com.springboot.library.repository.BookRepository;
import com.springboot.library.service.BookService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    @PersistenceContext
    EntityManager em;

    @Override
    public Book saveBook(Book book) {
      return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book updateBook) {
        if (bookRepository.existsById(id)) {
            updateBook.setId(id);
            return bookRepository.save(updateBook);
        } else {
            throw new BookNotFoundException("Book Not Found !");
        }
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found !"));
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public String deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Book Delete Successfully";
        } else {
            throw new BookNotFoundException("Book Not Found !");
        }
    }
}
