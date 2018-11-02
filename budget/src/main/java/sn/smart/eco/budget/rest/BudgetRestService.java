package sn.smart.eco.budget.rest;

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

import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.budget.repositories.BudgetRepository;
import sn.smart.eco.clients.model.ClientEntity;

@RestController
@RequestMapping("/rest/budget")
public class BudgetRestService {
	
	@Autowired
	  private BudgetRepository repository;

	  @GetMapping("/find/{client}")
	  public Budget findBudgetByClient(@PathVariable @NonNull ClientEntity client) {
	    return  repository.findByClient(client);
	    
	  }

	  @PostMapping("/add")
	  public Budget addBudget(@RequestBody @NonNull Budget bt) {
	    return repository.save(bt);
	  }
	  
	  @PutMapping("/bugdet/{id}")
	  public Budget updateBudget(@PathVariable(value = "id") Long budgetId,
	                                           @RequestBody Budget budgetDetails) {
		  	
		  Budget budget = repository.findById(budgetId).orElseThrow(() -> new RuntimeException("Erreur de Modification"));

		  budget.setDateDebut(budgetDetails.getDateDebut());
		  budget.setDateFin(budgetDetails.getDateFin());
		  budget.setMontant(budgetDetails.getMontant());
	      Budget updateBudget = repository.save(budget);
	      return updateBudget;
	  }
	  
	// Delete a Budget
	  @DeleteMapping("/bugdet/{id}")
	  public ResponseEntity<?> deleteBudget(@PathVariable(value = "id") Long budgetId) {
		  Budget budget = repository.findById(budgetId)
	              .orElseThrow(() -> new RuntimeException("Erreur de Suppression"));

		  repository.delete(budget);

	      return ResponseEntity.ok().build();
	  }

	 
}
