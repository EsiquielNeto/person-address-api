package com.project.personaddress.exceptions;

public class NonExistingPersonException extends RuntimeException implements ErrorCode{

    public NonExistingPersonException(final String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "Not found!";
    }
}
