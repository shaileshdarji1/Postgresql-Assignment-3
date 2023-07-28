package com.springboot.library.exception;

import java.text.RuleBasedCollator;

public class LibraryNotFoundException extends RuntimeException {
    public LibraryNotFoundException(String message) {
        super(message);
    }
}
