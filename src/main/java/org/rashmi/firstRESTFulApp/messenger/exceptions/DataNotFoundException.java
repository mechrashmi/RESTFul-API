package org.rashmi.firstRESTFulApp.messenger.exceptions;

public class DataNotFoundException extends RuntimeException {
	
	public DataNotFoundException(String error) {
		super(error);
	}
}
