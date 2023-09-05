package com.example.springmongo.exceptions;

public class BookIdUniqueConstrainException extends RuntimeException{

    public BookIdUniqueConstrainException() {
    }

    public BookIdUniqueConstrainException(String message) {
        super(message);
    }
}
