package sn.smart.eco.auth.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import sn.smart.eco.auth.model.User;

@Component
public interface TokenHandler {
	Optional<UserDetails> parseUserFromToken(String token);

    String createTokenForUser(User user);

}
