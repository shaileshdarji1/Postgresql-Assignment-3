package com.springboot.library.controller;

import com.springboot.library.entity.Author;
import com.springboot.library.entity.Book;
import com.springboot.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}
