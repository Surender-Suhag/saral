package com.test.frmw.saral.exceptions;

public class KeywordNotFoundException extends Throwable {
    public KeywordNotFoundException(String message) {
        super(message);
    }

    public KeywordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeywordNotFoundException(Throwable cause) {
        super(cause);
    }
}
