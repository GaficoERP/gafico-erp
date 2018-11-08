package sn.smart.eco.auth.service;

import sn.smart.eco.auth.model.User;

public interface SecurityService {
	User currentUser();

	String login(String username, String password);

}
