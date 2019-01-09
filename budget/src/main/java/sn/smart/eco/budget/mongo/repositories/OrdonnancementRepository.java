package sn.smart.eco.budget.mongo.repositories;

import sn.smart.eco.budget.model.Ordonnancement;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdonnancementRepository extends MongoRepository<Ordonnancement, Integer> {

  // Optional<List<Ordonnancement>> findByBudget(String budget);

  Optional<List<Ordonnancement>> findByEngagementOrderByReferenceDesc(Integer engagement);

  Optional<Ordonnancement> findByReference(String reference);

  Optional<Ordonnancement> findFirstByEngagement(Integer engagement, Sort sort);
}
