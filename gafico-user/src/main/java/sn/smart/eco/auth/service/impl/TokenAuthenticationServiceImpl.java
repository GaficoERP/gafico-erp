package sn.smart.eco.auth.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import sn.smart.eco.auth.service.TokenAuthenticationService;
import sn.smart.eco.auth.service.TokenHandler;

@Service
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {
	
	@Autowired
	private TokenHandler tokenHandler;

	@Override
	public Authentication getAuthentication(HttpServletRequest request) {
		final String authHeader = request.getHeader("authorization");
        if (authHeader == null) return null;
        if (!authHeader.startsWith("Bearer")) return null;

        final String jwt = authHeader.substring(7);
        if (jwt.isEmpty()) return null;

        return tokenHandler
                .parseUserFromToken(jwt)
                .map(UserAuthentication::new)
                .orElse(null);
	}

}
