package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.commonjpa.model.Level;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, String> {
}
