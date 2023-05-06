package com.deliveryfoodapp.exceptions;

public class WithoutBalanceException extends RuntimeException{
	public WithoutBalanceException(String customerName) {
		super(customerName + "does not have sufficient funds to complete the order");
	}

	public WithoutBalanceException(String message, Throwable cause) {
		super(message, cause);
	}
}
