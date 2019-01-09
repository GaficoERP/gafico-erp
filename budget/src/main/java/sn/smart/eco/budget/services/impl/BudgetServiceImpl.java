package sn.smart.eco.budget.services.impl;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.budget.repositories.BudgetRepository;
import sn.smart.eco.budget.services.BudgetService;
import sn.smart.eco.commonjpa.model.Exercice;
import sn.smart.eco.commonjpa.service.ExerciceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {

  @Autowired
  private BudgetRepository repository;
  @Autowired
  private ExerciceService exoService;

  @Override
  public Budget findBudgetByExercice(@NonNull Exercice exercice) {
    return repository.findByExercice(exercice).orElse(null);

  }

  @Override
  public Budget addBudget(@NonNull Budget bt) {
    return repository.save(bt);
  }

  @Override
  public Budget updateBudget(Budget budgetDetails) {

    Budget budget = repository.findByName(budgetDetails.getName())
        .orElseThrow(() -> new RuntimeException("Erreur de Modification"));

    budget.setExercice(budgetDetails.getExercice());
    budget.setName(budgetDetails.getName());
    Budget updateBudget = repository.save(budget);
    return updateBudget;
  }

  // Delete a Budget
  @Override
  public ResponseEntity<?> deleteBudget(String budgetName) {
    Budget budget = repository.findByName(budgetName)
        .orElseThrow(() -> new RuntimeException("Erreur de Suppression"));

    repository.delete(budget);

    return ResponseEntity.ok().build();
  }

  @Override
  public Budget findCurrentBudget() {
    Exercice exo = exoService.findCurrent();
    if (exo != null) {
      Optional<Budget> budget = repository.findByExercice(exo);
      if (budget.isPresent()) {
        return budget.get();
      }
    }
    return null;
  }
}
