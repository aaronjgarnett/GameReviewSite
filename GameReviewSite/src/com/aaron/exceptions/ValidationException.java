/*
 * Filename: ValidationException.java
 * author: Aaron Garnett
 * date: 3/2/2020 original
 * 
 * */
package com.aaron.exceptions;

/**
 * @author aaron
 *
 */
public class ValidationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException() {
		super("Password was not valid!");
	}
}