package sn.smart.eco.budget.mongo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sn.smart.eco.budget.model.Engagement;

@Repository
public interface EngagementRepository extends MongoRepository<Engagement, Integer> {

	Optional<List<Engagement>> findByBudgetLine(Integer budgetLine);

	Optional<Engagement> findByReference(String reference);

	List<Engagement> findAll();

	Optional<Engagement> findFirstByBudgetLine(Integer engagement, Sort sort);

}
