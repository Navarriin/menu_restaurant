package com.navarro.Restaurant.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.EmptyStackException;

@ControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerException() {
        return new ResponseEntity<>("This field is null!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyStackException.class)
    public ResponseEntity<String> EmptyStackException() {
        return new ResponseEntity<>("List empty!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> IllegalArgumentException() {
        return new ResponseEntity<>("This argument is not valid!", HttpStatus.BAD_REQUEST);
    }

}
