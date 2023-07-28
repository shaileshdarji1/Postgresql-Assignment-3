package com.springboot.library.exception.handler;

import com.springboot.library.exception.*;
import jakarta.validation.constraints.Email;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({AuthorNotFoundException.class,
            BookNotFoundException.class,
            BorrowingNotFoundException.class,
            LibraryNotFoundException.class,
            UserNotFoundException.class})
    public Map<String, String> authorNotFoundException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return error;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String,String> handleIntegrity(DataIntegrityViolationException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("message",ex.getMessage());
        return errorMap;
    }
}
