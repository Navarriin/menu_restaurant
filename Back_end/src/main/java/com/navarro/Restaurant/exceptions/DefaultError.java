package com.navarro.Restaurant.exceptions;

public class DefaultError {

    private final int code;
    private final String message;

    public DefaultError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
