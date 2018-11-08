package sn.smart.eco.auth.service.impl;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sn.smart.eco.auth.model.Role;
import sn.smart.eco.auth.model.User;
import sn.smart.eco.auth.repositories.UserRepository;
import sn.smart.eco.auth.service.TokenHandler;

@Component
public class TokenHandlerImpl implements TokenHandler {

	
	@Value("${app.jwt.secret}")
    private String secret;

	@Autowired
    private UserRepository userRepository;

	@Override
	public Optional<UserDetails> parseUserFromToken(String token) {
		final String subject = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        final User user = userRepository.getOne(Long.valueOf(subject));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return Optional.ofNullable(new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities));
	}

	@Override
	public String createTokenForUser(User user) {
		final ZonedDateTime afterOneWeek = ZonedDateTime.now().plusWeeks(1);

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(afterOneWeek.toInstant()))
                .compact();
	}

}
