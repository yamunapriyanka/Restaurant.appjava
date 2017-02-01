package com.yamuna.exception;

public class InvalidFoodException extends Exception {

	public InvalidFoodException(String msg, Throwable cause) {
		super(msg, cause);
	
	}

	public InvalidFoodException(String msg) {
		super(msg);
		
	}

}
