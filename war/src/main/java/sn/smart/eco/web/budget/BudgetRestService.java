package sn.smart.eco.web.budget;

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.budget.services.BudgetLineService;
import sn.smart.eco.budget.services.BudgetService;
import sn.smart.eco.commonjpa.model.Exercice;
import sn.smart.eco.web.budget.model.BudgetEntity;

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
  @Autowired
  private BudgetLineService blService;

  @GetMapping("/find/{exercice}")
  public Budget findBudgetByExercice(@PathVariable @NonNull Exercice exercice) {
    return service.findBudgetByExercice(exercice);

  }

  @GetMapping("/find")
  public Budget findBudget() {
    return service.findCurrentBudget();

  }

  @PostMapping("/save")
  public Budget saveBudget(@RequestBody @NonNull BudgetEntity entity) {
    Budget savedBudget = service.addBudget(entity.getBudget());
    if (savedBudget != null) {
      entity.getBudgetLines().forEach(bl -> bl.setBudgetName(savedBudget.getName()));
      blService.saveAll(entity.getBudgetLines());
    }

    return savedBudget;
  }

  @PutMapping("/update")
  public Budget updateBudget(@RequestBody Budget budgetDetails) {
    return service.updateBudget(budgetDetails);
  }

  // Delete a Budget
  @DeleteMapping("/delete/{name}")
  public ResponseEntity<?> deleteBudget(@PathVariable(value = "name") String budget) {
    return service.deleteBudget(budget);
  }


}
