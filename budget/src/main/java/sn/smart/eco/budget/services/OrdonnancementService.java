package sn.smart.eco.budget.services;

import sn.smart.eco.budget.model.Ordonnancement;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrdonnancementService {
  Ordonnancement save(Ordonnancement order);

  List<Ordonnancement> saveAll(List<Ordonnancement> orders);

  List<Ordonnancement> findAllByGroupByEngagement();

  List<Ordonnancement> findByEngagement(Integer engagement);

  ResponseEntity<?> delete(Ordonnancement order);

  String getNextReferenceCode(Integer engagement);
}
