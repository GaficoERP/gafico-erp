package sn.smart.eco.budget.services.impl;

import sn.smart.eco.budget.model.BudgetLine;
import sn.smart.eco.budget.mongo.repositories.BudgetLineRepository;
import sn.smart.eco.budget.services.BudgetLineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class BudgetLineServiceImpl implements BudgetLineService {
  @Autowired
  private BudgetLineRepository repository;

  @Override
  public List<BudgetLine> findLinesByBudget(@NonNull String budgetName) {
    Optional<List<BudgetLine>> lines = repository.findByBudgetName(budgetName);
    if (lines.isPresent()) {
      return lines.get();
    }

    return new ArrayList<>();
  }

  @Override
  public List<BudgetLine> saveAll(@NonNull List<BudgetLine> budgetLines) {
    return repository.saveAll(budgetLines);
  }

}
