package com.victordev.security_moitor.service.exception;

public class NotFoundError extends RuntimeException{
    public NotFoundError(String message) {
        super(message);
    }
}
