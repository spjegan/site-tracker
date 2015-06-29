package com.tr.sitetracker.exception.mappers;

import java.io.Serializable;

/**
 * Created by Jegan on 6/18/2015.
 */
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 5692454821932225291L;

	private String code;

	private String errorMessage;

	public ErrorResponse(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorResponse [code=").append(code)
				.append(", errorMessage=").append(errorMessage).append("]");
		return builder.toString();
	}
}
