package com.deliveryfoodapp.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {

  public CustomerAlreadyExistsException(String message) {
    super(message);
  }

  public CustomerAlreadyExistsException(String message, Throwable cause) {
    super(message, cause);
  }
}
