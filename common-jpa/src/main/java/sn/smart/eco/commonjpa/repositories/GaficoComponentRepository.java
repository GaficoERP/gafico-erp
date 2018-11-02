package sn.smart.eco.commonjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.smart.eco.commonjpa.model.GaficoComponent;

import java.util.List;
import java.util.Optional;

@Repository
public interface GaficoComponentRepository extends JpaRepository<GaficoComponent, String> {

  Optional<List<GaficoComponent>> findByInDefaultPack(boolean inDefaultPack);
}
