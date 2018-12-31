package sn.smart.eco.budget.services;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.commonjpa.model.Exercice;

import org.springframework.http.ResponseEntity;

public interface BudgetService {

  public Budget findBudgetByExercice(Exercice exercice);

  public Budget addBudget(Budget bt);

  public Budget updateBudget(Budget budgetDetails);

  public ResponseEntity<?> deleteBudget(String budgetName);

  public Budget findCurrentBudget();
}
