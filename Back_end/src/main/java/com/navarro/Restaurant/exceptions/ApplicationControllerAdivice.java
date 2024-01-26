package com.navarro.Restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationControllerAdivice extends ResponseEntityExceptionHandler {

    private final HttpStatus notFound = HttpStatus.NOT_FOUND;
    private final HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DefaultError> handleNoSuchElementException(NoSuchElementException ex) {

        return ResponseEntity.status(notFound)
                .body(new DefaultError(notFound.value(), "Resource not found"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultError> handleException(Exception ex) {
        return ResponseEntity.status(internalServerError)
                .body(new DefaultError(internalServerError.value(), "Internal Server Error"));
    }
}