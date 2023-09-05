package com.example.springmongo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SuperExceptionHandler {

    // TODO: handles a unique book ID exception
    @ExceptionHandler(value = BookIdUniqueConstrainException.class)
    public ResponseEntity<ApiException> IdUniqueHandler(
            BookIdUniqueConstrainException ex) {
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(apiEx);
    }

    // TODO: handles a case where a null or empty book name is imported
    @ExceptionHandler(value = EmptyBookNameNotAllowException.class)
    public ResponseEntity<ApiException> emptyBookNameHandler(
            EmptyBookNameNotAllowException ex) {
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                HttpStatus.NOT_ACCEPTABLE);
        return ResponseEntity.ok(apiEx);
    }

    // TODO: Handles a case where all books have been bought
    @ExceptionHandler(value = NoBookAvailableInStoreException.class)
    public ResponseEntity<ApiException> bookFinishHandler(
            NoBookAvailableInStoreException ex) {
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(apiEx);
    }

    // TODO: Handles all customer not found exceptions
    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<ApiException> customerNotFoundHandler(
            CustomerNotFoundException ex) {
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(apiEx);
    }


    // TODO: Handles all customer not found exceptions
    @ExceptionHandler(value = InvalidQuantityException.class)
    public ResponseEntity<ApiException> invalidQuantityHandler(
            InvalidQuantityException ex) {
        ApiException apiEx = new ApiException(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(apiEx);
    }
}
