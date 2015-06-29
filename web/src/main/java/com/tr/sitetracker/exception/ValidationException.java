package com.tr.sitetracker.exception;

/**
 * Created by Jegan on 6/18/2015.
 */
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 6305872157044479884L;

	public ValidationException() {
		super();
	}

	public ValidationException(String message, Throwable cause,
							   boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

}
