package sn.smart.eco.web.budget;

import sn.smart.eco.budget.model.BudgetLine;
import sn.smart.eco.budget.services.BudgetLineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/budgetline")
public class BudgetLineRestService {
  @Autowired
  private BudgetLineService service;

  @GetMapping("/findByBudget/{budgetName}")
  public List<BudgetLine> findLinesByBudget(@PathVariable @NonNull String budgetName) {
    return service.findLinesByBudget(budgetName);
  }
}
