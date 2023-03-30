package com.stevenhornghub.promotionrequest.exceptions;

public class IdDoesNotExistException extends RuntimeException{
    public IdDoesNotExistException(String message) {
        super(message);
    }
}