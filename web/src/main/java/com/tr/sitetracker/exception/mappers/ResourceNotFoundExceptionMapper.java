/**
 * 
 */
package com.tr.sitetracker.exception.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;
import com.tr.sitetracker.exception.ResourceNotFoundException;

/**
 * @author Jegan
 *
 */
public class ResourceNotFoundExceptionMapper extends
		AbstractExceptionMapper<ResourceNotFoundException> implements
		ExceptionMapper<ResourceNotFoundException> {

	private static final ILogger logger = LoggerFactory
			.getLogger(ResourceNotFoundExceptionMapper.class);

	@Override
	public Response toResponse(ResourceNotFoundException ex) {
		logger.error(
				"Resource not found error while processing the request. {}",
				ex, ex.getMessage());
		return sendError(ex.getMessage(), Response.Status.NOT_FOUND);
	}

}
