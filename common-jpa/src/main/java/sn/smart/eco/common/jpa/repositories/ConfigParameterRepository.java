package sn.smart.eco.common.jpa.repositories;

import sn.smart.eco.common.jpa.model.ConfigParameter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigParameterRepository extends JpaRepository<ConfigParameter, String> {

  Optional<List<ConfigParameter>> findByComponentId(String component);

  Optional<List<ConfigParameter>> findByComponentInDefaultPack(boolean inDefaultPack);
}
