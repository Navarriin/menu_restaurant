package com.navarro.Restaurant.exceptions;

import org.springframework.http.HttpStatus;

public record RestErrorMessage(HttpStatus status, String message) {}
