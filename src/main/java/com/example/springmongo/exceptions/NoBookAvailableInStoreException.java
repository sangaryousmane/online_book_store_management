package com.example.springmongo.exceptions;

public class NoBookAvailableInStoreException extends RuntimeException{

    public NoBookAvailableInStoreException() {
    }

    public NoBookAvailableInStoreException(String message) {
        super(message);
    }
}
