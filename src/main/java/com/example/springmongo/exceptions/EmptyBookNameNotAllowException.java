package com.example.springmongo.exceptions;

public class EmptyBookNameNotAllowException extends RuntimeException{

    public EmptyBookNameNotAllowException() {
    }

    public EmptyBookNameNotAllowException(String message) {
        super(message);
    }
}
