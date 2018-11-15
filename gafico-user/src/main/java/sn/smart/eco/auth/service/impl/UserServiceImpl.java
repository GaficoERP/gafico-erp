package sn.smart.eco.auth.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sn.smart.eco.auth.model.User;
import sn.smart.eco.auth.repositories.UserRepository;
import sn.smart.eco.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User create(User user) {
		System.out.println("user: " + user.getPassword());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		Optional<User> user= userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		 return null;
	}

	@Override
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> { user.setPassword(""); return user;}).collect(Collectors.toList());
	}

	@Override
	public User update(Long id, User user) {
		Optional<User> _user= userRepository.findById(id);
		if(_user.isPresent()) {
			User newUser =  _user.get();
			newUser.setPassword(user.getPassword());
			newUser.setUsername(user.getUsername());
			newUser.setRoles(user.getRoles());
			return create(newUser);
		}
		 return null;
	}

}
