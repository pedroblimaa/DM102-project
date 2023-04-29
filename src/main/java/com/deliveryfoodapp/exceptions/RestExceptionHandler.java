package com.deliveryfoodapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleCustomerAlreadyExistsExceptionException(CustomerAlreadyExistsException ex) {
        return new ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
