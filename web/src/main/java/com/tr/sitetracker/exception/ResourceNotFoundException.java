/**
 * 
 */
package com.tr.sitetracker.exception;

/**
 * @author Jegan
 *
 */
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -9038104982530548758L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause,
							   boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

}
