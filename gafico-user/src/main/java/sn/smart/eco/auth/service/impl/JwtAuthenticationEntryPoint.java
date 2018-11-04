package sn.smart.eco.auth.service.impl;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable  {

	
	private static final long serialVersionUID = -1344119153529964442L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setHeader("WWW-Authenticate", "'Bearer token_type=\"JWT\"'");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

	}

}
