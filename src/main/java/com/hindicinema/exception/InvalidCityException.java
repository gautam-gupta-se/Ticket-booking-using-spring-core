package com.hindicinema.exception;
public class InvalidCityException extends HindiCinemaException {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * This Exception is thrown from RegistrationService class with error message
	 * RegistrationService.INVALID_CITY if the given city is not matching the
	 * constraints given in the regular expression.
	 * 
	 * 
	 *
	 */
	public InvalidCityException(String message) {
		super(message);
	}
}
