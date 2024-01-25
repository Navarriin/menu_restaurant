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
    public ResponseEntity<DefaultError> responseEntityNoSuchElementException(NoSuchElementException err) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new DefaultError(HttpStatus.BAD_REQUEST.value(), "Id not found!"));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<DefaultError> responseEntityNullPointerException(NullPointerException err) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new DefaultError(HttpStatus.NOT_FOUND.value(), "Element is null!"));
    }
}