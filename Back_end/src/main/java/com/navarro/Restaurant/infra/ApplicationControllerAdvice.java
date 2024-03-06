package com.navarro.Restaurant.infra;

import com.navarro.Restaurant.exceptions.MenuNotFoundException;
import com.navarro.Restaurant.exceptions.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    private final HttpStatus notFound = HttpStatus.NOT_FOUND;

    @ExceptionHandler(MenuNotFoundException.class)
    private ResponseEntity<RestErrorMessage> MenuNotFoundHandler(MenuNotFoundException exception) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(notFound, exception.getMessage());
        return ResponseEntity.status(notFound).body(restErrorMessage);
    }
}