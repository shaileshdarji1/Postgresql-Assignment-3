package com.springboot.library.controller;

import com.springboot.library.entity.Author;
import com.springboot.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }

    @GetMapping("/page/{offset}/{size}/{field}")
    public Page<Author> getAuthorPageWise(@PathVariable int offset,@PathVariable int size,@PathVariable String field){
        return authorService.findAuthorPageWise(offset,size,field);
    }
}
