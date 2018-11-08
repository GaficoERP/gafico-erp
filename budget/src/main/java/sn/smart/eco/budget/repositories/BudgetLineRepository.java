package sn.smart.eco.budget.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.budget.model.BudgetLine;

@Repository
public interface BudgetLineRepository extends MongoRepository<BudgetLine, String>{
	
	Optional<BudgetLine> findByAccount(String account);
	Optional<BudgetLine> findByLabel(String label);
	Optional<Budget> findByBudget(Budget budget);

}
