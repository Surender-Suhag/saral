package com.test.frmw.saral.exceptionHandler;

import com.test.frmw.saral.exceptions.EntityAlreadyExistsException;
import com.test.frmw.saral.exceptions.IncorrectParameterValueException;
import com.test.frmw.saral.exceptions.MissingParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler({MissingParameterException.class, IncorrectParameterValueException.class, EntityAlreadyExistsException.class})
    public ResponseEntity<Object> parameterDetailsRelatedExceptionHandler(RuntimeException ex) {
        logger.error(ex.getMessage(),ex);
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }


    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message) {
        ApiError apiError = new ApiError(status, message);
        return new ResponseEntity<>(apiError, status);
    }

}
