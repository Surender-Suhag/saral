package com.test.frmw.saral.exceptions;

public class ParameterDoesNotExistInDbException extends Throwable {

    public ParameterDoesNotExistInDbException(String message) {
        super(message);
    }

    public ParameterDoesNotExistInDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterDoesNotExistInDbException(Throwable cause) {
        super(cause);
    }
}
