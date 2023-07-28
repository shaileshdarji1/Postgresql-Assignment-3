package com.springboot.library.controller;


import com.springboot.library.entity.Library;
import com.springboot.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping
    public Library saveLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    @GetMapping
    public List<Library> getAllLibrary() {
        return libraryService.getAllLibrary();
    }

    @GetMapping("/{id}")
    public Library getLibrary(@PathVariable Long id) {
        return libraryService.getLibrary(id);
    }

    @PutMapping("{id}")
    public Library updateLibrary(@PathVariable Long id, @RequestBody Library library) {
        return libraryService.updateLibrary(id, library);
    }

    @DeleteMapping("/{id}")
    public String deleteLibrary(@PathVariable Long id) {
        return libraryService.deleteLibrary(id);
    }
}
