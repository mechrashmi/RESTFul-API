package org.rashmi.firstRESTFulApp.messenger.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rashmi.firstRESTFulApp.messenger.exceptions.DataNotFoundException;
import org.rashmi.firstRESTFulApp.messenger.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage err = new ErrorMessage(exception.getMessage(), Status.NOT_FOUND.getStatusCode(), "google.com");
		return Response.status(Status.NOT_FOUND).entity(err).build();
	}

}
