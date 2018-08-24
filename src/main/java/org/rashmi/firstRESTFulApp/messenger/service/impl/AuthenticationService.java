package org.rashmi.firstRESTFulApp.messenger.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;


public class AuthenticationService {
	public boolean authenticate(String credentials) {
		if(credentials == null || credentials.equals(""))
			return false;
		
		credentials = credentials.replace("Basic ", "");

		String userNameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(credentials);
			userNameAndPassword = new String(decodedBytes, "UTF-8");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		final StringTokenizer tokenizer = new StringTokenizer(userNameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		
		boolean authenticationStatus = "admin".equals(username) && "admin".equals(password);
		return authenticationStatus;
	}

}
