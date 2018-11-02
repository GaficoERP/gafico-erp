package sn.smart.eco.budget.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sn.smart.eco.budget.model.Budget;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, String> {

}
