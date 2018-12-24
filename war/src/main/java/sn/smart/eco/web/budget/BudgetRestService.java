package sn.smart.eco.web.budget;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.budget.services.BudgetService;
import sn.smart.eco.commonjpa.model.Exercice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/budget")
public class BudgetRestService {

  @Autowired
  private BudgetService service;

  @GetMapping("/find/{client}")
  public Budget findBudgetByExercice(@PathVariable @NonNull Exercice exercice) {
    return service.findBudgetByExercice(exercice);

  }

  @PostMapping("/add")
  public Budget addBudget(@RequestBody @NonNull Budget bt) {
    return service.addBudget(bt);
  }

  @PutMapping("/bugdet")
  public Budget updateBudget(@RequestBody Budget budgetDetails) {
    return service.updateBudget(budgetDetails);
  }

  // Delete a Budget
  @DeleteMapping("/bugdet/{name}")
  public ResponseEntity<?> deleteBudget(@PathVariable(value = "name") String budget) {
    return service.deleteBudget(budget);
  }


}
