package com.test.frmw.saral.exceptions;

public class IncorrectParameterValueException extends RuntimeException {
    public IncorrectParameterValueException(String message) {
        super(message);
    }

    public IncorrectParameterValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectParameterValueException(Throwable cause) {
        super(cause);
    }
}
