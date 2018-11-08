package sn.smart.eco.auth.service;

import java.util.List;

import sn.smart.eco.auth.model.User;

public interface UserService {
	User create(User user);
	User findByUsername(String username);
	User findById(Long id);
	List<User> findAll();
	User update(Long id, User user);

}
