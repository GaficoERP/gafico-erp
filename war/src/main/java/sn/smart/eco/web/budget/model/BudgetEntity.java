package sn.smart.eco.web.budget.model;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.budget.model.BudgetLine;

import java.util.List;

public class BudgetEntity {
  private Budget budget;
  private List<BudgetLine> budgetLines;

  public Budget getBudget() {
    return budget;
  }

  public void setBudget(Budget budget) {
    this.budget = budget;
  }

  public List<BudgetLine> getBudgetLines() {
    return budgetLines;
  }

  public void setBudgetLines(List<BudgetLine> budgetLines) {
    this.budgetLines = budgetLines;
  }
}
