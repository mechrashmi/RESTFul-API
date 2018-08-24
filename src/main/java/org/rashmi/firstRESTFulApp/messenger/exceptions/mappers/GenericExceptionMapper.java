package org.rashmi.firstRESTFulApp.messenger.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rashmi.firstRESTFulApp.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage err = new ErrorMessage(exception.getMessage(), Status.BAD_REQUEST.getStatusCode(), "google.com");
		return Response.status(Status.BAD_REQUEST).entity(err).build();
	}

}
