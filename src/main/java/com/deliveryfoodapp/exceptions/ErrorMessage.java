package com.deliveryfoodapp.exceptions;

public class ErrorMessage {
  private String message;
  private int statusCode;

  public ErrorMessage(String message, int statusCode) {
    this.message = message;
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public int getStatusCode() {
    return statusCode;
  }
}