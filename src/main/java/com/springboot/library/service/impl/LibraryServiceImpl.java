package com.springboot.library.service.impl;

import com.springboot.library.entity.Library;
import com.springboot.library.exception.LibraryNotFoundException;
import com.springboot.library.repository.LibraryRepository;
import com.springboot.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library updateLibrary(Long id, Library updateLibrary) {
        if (libraryRepository.existsById(id)) {
            updateLibrary.setId(id);
            return libraryRepository.save(updateLibrary);
        } else {
            throw new LibraryNotFoundException("Library Not Found Exception !");
        }
    }

    @Override
    public Library getLibrary(Long id) {
        return libraryRepository.findById(id).orElseThrow(() -> new LibraryNotFoundException("Library Not Found Exception !"));
    }

    @Override
    public List<Library> getAllLibrary() {
        return libraryRepository.findAll();
    }

    @Override
    public String deleteLibrary(Long id) {
        if (libraryRepository.existsById(id)) {
            libraryRepository.deleteById(id);
            return "Library Delete Successfully";
        } else {
            throw new LibraryNotFoundException("Library Not Found Exception !");
        }

    }
}
