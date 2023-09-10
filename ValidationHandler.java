package com.boot.aatral.exception;

public class ValidationHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationHandler(String message) {
		super(message);
	}

	public ValidationHandler() {
		super();
	}
}
