package com.navarro.Restaurant.infra;

import com.navarro.Restaurant.exceptions.MenuNotFoundException;
import com.navarro.Restaurant.exceptions.RestErrorMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    private final HttpStatus notFound = HttpStatus.NOT_FOUND;
    private final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(MenuNotFoundException.class)
    private ResponseEntity<RestErrorMessage> MenuNotFoundHandler(MenuNotFoundException exception) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(notFound, exception.getMessage());
        return ResponseEntity.status(notFound).body(restErrorMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<RestErrorMessage> DataIntegrityHandler(DataIntegrityViolationException exception) {
        return ResponseEntity.status(badRequest)
                .body(new RestErrorMessage(badRequest, "The value is too long!"));
    }
}