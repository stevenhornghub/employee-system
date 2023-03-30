package com.stevenhornghub.promotionrequest.exceptions;

public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException(String message) {
        super(message);
    }
}
