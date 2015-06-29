package com.tr.sitetracker.exception.mappers;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;
import com.tr.sitetracker.exception.ValidationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Jegan on 6/18/2015.
 */
@Provider
public class ValidationExceptionMapper extends
		AbstractExceptionMapper<ValidationException> implements
		ExceptionMapper<ValidationException> {

	private static final ILogger logger = LoggerFactory
			.getLogger(ValidationExceptionMapper.class);

	@Override
	public Response toResponse(ValidationException ex) {
		logger.error("Validation error while processing the request. {}", ex,
				ex.getMessage());
		return sendError(ex.getMessage(), Response.Status.BAD_REQUEST);
	}
}
