package sn.smart.eco.commonjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.smart.eco.commonjpa.model.ConfigParameter;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigParameterRepository extends JpaRepository<ConfigParameter, String> {

  Optional<List<ConfigParameter>> findByComponentId(String component);

  Optional<List<ConfigParameter>> findByComponentInDefaultPack(boolean inDefaultPack);
}
