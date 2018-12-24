package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.commonjpa.model.Level;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
  // Optional<List<Level>> findByPrevious(Level previous);

  Optional<Level> findByPositionAndStructuration(Integer position, String structuration);
}
