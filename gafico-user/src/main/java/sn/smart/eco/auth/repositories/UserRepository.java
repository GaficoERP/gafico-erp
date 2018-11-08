package sn.smart.eco.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.smart.eco.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
