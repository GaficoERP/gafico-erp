package sn.smart.eco.clients.repositories;

import sn.smart.eco.clients.model.GaficoLicense;
import sn.smart.eco.common.jpa.model.GaficoComponent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GaficoLicenseRepository extends JpaRepository<GaficoLicense, String> {
  Optional<List<GaficoLicense>> findByOwnerName(String ownerName);

  Optional<List<GaficoLicense>> findByComponent(GaficoComponent component);
}
