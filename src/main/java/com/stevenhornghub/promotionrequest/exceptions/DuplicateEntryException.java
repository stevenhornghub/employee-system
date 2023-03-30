package com.stevenhornghub.promotionrequest.exceptions;

public class DuplicateEntryException extends RuntimeException{
    public DuplicateEntryException(String message) {
        super(message);
    }
}
