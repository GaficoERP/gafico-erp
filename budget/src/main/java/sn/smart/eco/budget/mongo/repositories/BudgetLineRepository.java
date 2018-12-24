package sn.smart.eco.budget.mongo.repositories;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.budget.model.BudgetLine;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetLineRepository extends MongoRepository<BudgetLine, String> {

  Optional<BudgetLine> findByCode(String code);

  Optional<BudgetLine> findByLabel(String label);

  Optional<Budget> findByBudgetName(String budget);

}
