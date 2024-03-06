package com.navarro.Restaurant.exceptions;

public class MenuNotFoundException extends RuntimeException {

    public MenuNotFoundException(){
        super("Food not found!");
    }
    public MenuNotFoundException(String message) {
        super(message);
    }
}

