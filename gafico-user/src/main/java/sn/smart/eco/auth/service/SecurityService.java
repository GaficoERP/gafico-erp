package sn.smart.eco.auth.service;

public interface SecurityService {
	String findLoggedInUsername();

	void autologin(String username, String password);

}
