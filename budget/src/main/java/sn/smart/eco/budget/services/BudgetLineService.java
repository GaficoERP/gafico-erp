package sn.smart.eco.budget.services;

import sn.smart.eco.budget.model.BudgetLine;

import java.util.List;

public interface BudgetLineService {

  List<BudgetLine> findLinesByBudget(String budgetName);

  List<BudgetLine> saveAll(List<BudgetLine> budgetLines);
}
