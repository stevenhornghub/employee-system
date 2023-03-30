package com.stevenhornghub.promotionrequest.exceptions;

public class ItDoesNotExistException extends RuntimeException{
    public ItDoesNotExistException(String message) {
        super(message);
    }
}
