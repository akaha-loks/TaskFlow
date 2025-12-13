package com.akaha.taskflow.auth.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super("Email Already Exists");
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
