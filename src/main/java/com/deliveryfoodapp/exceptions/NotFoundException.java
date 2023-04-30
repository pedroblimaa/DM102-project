package com.deliveryfoodapp.exceptions;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String item, Long id) {
    super(item + "with id " + id + " not found");
  }

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

}
