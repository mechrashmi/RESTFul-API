package org.rashmi.firstRESTFulApp.messenger.authentication;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ext.Provider;

import org.rashmi.firstRESTFulApp.messenger.exceptions.AuthenticationFailedException;
import org.rashmi.firstRESTFulApp.messenger.exceptions.DataNotFoundException;
import org.rashmi.firstRESTFulApp.messenger.service.impl.AuthenticationService;

public class RestAuthenticationFilter implements Filter {
	public static final String AUTHENTICATION_HEADER = "Authorization";
	private FilterConfig fcon = null;
	
	@Override
	public void destroy() {
		fcon = null;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		if(request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authCredentials = httpServletRequest.getHeader(AUTHENTICATION_HEADER);
			
			AuthenticationService authService = new AuthenticationService();
			boolean status = authService.authenticate(authCredentials);
			if(status) {
				filter.doFilter(request, response);
			}
			else {
				if(response instanceof HttpServletResponse) {
					HttpServletResponse httpResponse = (HttpServletResponse) response;
					((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}

			}
		}
		
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		fcon = conf;
		
	}


}
