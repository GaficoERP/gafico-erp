package sn.smart.eco.budget.repositories;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.commonjpa.model.Exercice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

  Optional<Budget> findByExercice(Exercice exercice);

  Optional<Budget> findByName(String name);
}
