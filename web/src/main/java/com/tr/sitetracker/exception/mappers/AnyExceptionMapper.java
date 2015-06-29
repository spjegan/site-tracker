package com.tr.sitetracker.exception.mappers;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Jegan on 6/18/2015.
 */
@Provider
public class AnyExceptionMapper extends AbstractExceptionMapper<Exception>
		implements ExceptionMapper<Exception> {

	private static final ILogger logger = LoggerFactory
			.getLogger(AnyExceptionMapper.class);

	@Override
	public Response toResponse(Exception ex) {
		logger.error("Unexpected error while processing the request. {}", ex,
				ex.getMessage());
		return sendError(ex.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
	}
}
