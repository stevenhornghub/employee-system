package com.stevenhornghub.promotionrequest.exceptions;

public class PasswordIsIncorrectException extends RuntimeException{
    public PasswordIsIncorrectException(String message) {
        super(message);
    }
}
