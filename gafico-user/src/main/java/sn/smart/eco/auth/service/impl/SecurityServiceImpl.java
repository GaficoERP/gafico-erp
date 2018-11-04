package sn.smart.eco.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import sn.smart.eco.auth.model.User;
import sn.smart.eco.auth.repositories.UserRepository;
import sn.smart.eco.auth.service.SecurityService;
import sn.smart.eco.auth.service.TokenHandler;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
	private TokenHandler tokenHandler;
    
    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);



	@Override
	public User currentUser() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return userRepository.findByUsername(((UserDetails)userDetails).getUsername());
        }

        return null;
	}

	@Override
	public String login(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Login %s successfully!", username));
            User user = userRepository.findByUsername(username);
            return tokenHandler.createTokenForUser(user);
            
        }
        return null;

	}

}
