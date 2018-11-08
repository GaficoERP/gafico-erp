package sn.smart.eco.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.smart.eco.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
