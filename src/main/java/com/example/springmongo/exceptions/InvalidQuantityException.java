package com.example.springmongo.exceptions;

public class InvalidQuantityException extends RuntimeException{

    public InvalidQuantityException() {
    }

    public InvalidQuantityException(String message) {
        super(message);
    }
}
