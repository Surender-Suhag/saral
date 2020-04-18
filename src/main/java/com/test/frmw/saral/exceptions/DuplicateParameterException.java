package com.test.frmw.saral.exceptions;

public class DuplicateParameterException extends Throwable {
    public DuplicateParameterException(String message) {
        super(message);
    }

    public DuplicateParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateParameterException(Throwable cause) {
        super(cause);
    }
}
