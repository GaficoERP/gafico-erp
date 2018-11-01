package sn.smart.eco.common.jpa.repositories;

import sn.smart.eco.common.jpa.model.GaficoComponent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GaficoComponentRepository extends JpaRepository<GaficoComponent, String> {

  Optional<List<GaficoComponent>> findByInDefaultPack(boolean inDefaultPack);
}
