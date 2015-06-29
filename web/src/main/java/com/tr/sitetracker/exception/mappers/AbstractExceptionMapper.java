package com.tr.sitetracker.exception.mappers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Jegan on 6/18/2015.
 */
public class AbstractExceptionMapper<T extends Exception> {

	public Response sendError(String errorMessage,
			Response.Status responseStatus) {
		ErrorResponse errorResponse = new ErrorResponse(errorMessage);
		return Response.status(responseStatus).entity(errorResponse)
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}
