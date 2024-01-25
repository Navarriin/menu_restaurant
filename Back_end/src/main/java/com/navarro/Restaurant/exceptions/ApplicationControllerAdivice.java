package com.navarro.Restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationControllerAdivice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DefaultError> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new DefaultError(HttpStatus.NOT_FOUND.value(), "Resource not found"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultError> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error"));
    }
}