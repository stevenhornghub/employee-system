package com.stevenhornghub.promotionrequest.exceptions;

public class UsernameDoesNotExistException extends RuntimeException{
    public UsernameDoesNotExistException(String message) {
        super(message);
    }
}

