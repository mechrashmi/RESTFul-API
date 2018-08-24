package org.rashmi.firstRESTFulApp.messenger.exceptions;

public class AuthenticationFailedException extends RuntimeException {
	public AuthenticationFailedException(String errorMessage) {
		super(errorMessage);	
	}

}
