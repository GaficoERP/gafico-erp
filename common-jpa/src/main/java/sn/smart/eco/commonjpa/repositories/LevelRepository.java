package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.commonjpa.model.Level;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, String> {
  Optional<List<Level>> findByPrevious(Level previous);

  Optional<Integer> findCodeLengthByLevel(Level level);
}
