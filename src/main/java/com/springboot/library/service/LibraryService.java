package com.springboot.library.service;


import com.springboot.library.entity.Library;

import java.util.List;

public interface LibraryService {

    public Library saveLibrary(Library library);

    public Library updateLibrary(Long id, Library updateLibrary);

    public Library getLibrary(Long id);

    public List<Library> getAllLibrary();

    public String deleteLibrary(Long id);

}
