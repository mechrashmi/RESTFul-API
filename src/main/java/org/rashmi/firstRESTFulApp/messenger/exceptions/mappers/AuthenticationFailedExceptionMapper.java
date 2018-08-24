package org.rashmi.firstRESTFulApp.messenger.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rashmi.firstRESTFulApp.messenger.exceptions.AuthenticationFailedException;
import org.rashmi.firstRESTFulApp.messenger.model.ErrorMessage;

@Provider
public class AuthenticationFailedExceptionMapper implements ExceptionMapper<AuthenticationFailedException> {

	@Override
	public Response toResponse(AuthenticationFailedException exception) {
		ErrorMessage err = new ErrorMessage(exception.getMessage(), Status.UNAUTHORIZED.getStatusCode(), "Please provide valid userName and password");
		return Response.status(Status.UNAUTHORIZED).entity(err).build();
	}

}
