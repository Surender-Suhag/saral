package com.test.frmw.saral.exceptions;

public class ClassNotOfAutomationKeywordTypeException extends RuntimeException {
    public ClassNotOfAutomationKeywordTypeException(String message) {
        super(message);
    }

    public ClassNotOfAutomationKeywordTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassNotOfAutomationKeywordTypeException(Throwable cause) {
        super(cause);
    }
}
