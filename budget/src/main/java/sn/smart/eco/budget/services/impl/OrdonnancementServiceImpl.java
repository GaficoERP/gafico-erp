package sn.smart.eco.budget.services.impl;

import sn.smart.eco.budget.model.Ordonnancement;
import sn.smart.eco.budget.mongo.repositories.OrdonnancementRepository;
import sn.smart.eco.budget.services.OrdonnancementService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrdonnancementServiceImpl implements OrdonnancementService {
  @Autowired
  private OrdonnancementRepository repository;

  @Override
  public Ordonnancement save(@NonNull Ordonnancement order) {
    return repository.save(order);
  }

  @Override
  public List<Ordonnancement> findAllByGroupByEngagement() {
    Optional<List<Ordonnancement>> orders = repository.findAllGroupByEngagement();
    if (orders.isPresent()) {
      return orders.get();
    }

    return new ArrayList<>();
  }

  @Override
  public List<Ordonnancement> findByEngagement(@NonNull Integer engagement) {
    Optional<List<Ordonnancement>> orders = repository.findByEngagement(engagement);
    if (orders.isPresent()) {
      return orders.get();
    }

    return new ArrayList<>();
  }

  @Override
  public ResponseEntity<?> delete(@NonNull Ordonnancement order) {
    Ordonnancement savedOrder = repository.findByReference(order.getReference())
        .orElseThrow(() -> new RuntimeException("Erreur de Suppression"));

    repository.delete(savedOrder);

    return ResponseEntity.ok().build();
  }

  @Override
  public String getNextReferenceCode(Integer engagement) {
    int code = 1;
    Optional<Ordonnancement> order =
        repository.findFirstByEngagement(engagement, new Sort(Sort.Direction.DESC, "reference"));
    if (order.isPresent()) {
      String str = StringUtils.substringAfter(order.get().getReference(), "-");
      if (StringUtils.isNotEmpty(str)) {
        code = Integer.parseInt(str) + 1;
      }
    }
    return engagement + "-" + code;
  }

  @Override
  public List<Ordonnancement> saveAll(List<Ordonnancement> orders) {
    return repository.saveAll(orders);
  }

}
