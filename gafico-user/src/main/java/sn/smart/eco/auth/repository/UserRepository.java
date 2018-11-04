package sn.smart.eco.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.smart.eco.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
