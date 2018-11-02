package sn.smart.eco.budget.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.smart.eco.budget.model.BudgetLine;
import sn.smart.eco.budget.repositories.BudgetLineRepository;
import sn.smart.eco.budget.repositories.BudgetPlanLevelRepository;
import sn.smart.eco.common.model.PlanType;

@RestController
@RequestMapping("/rest/budgetLine")
public class BudgetLineService {
	
	 @Autowired
	  private BudgetLineRepository repository;

	  @GetMapping("/find/{account}")
	  public BudgetLine findBudgetByAccount(@PathVariable @NonNull String account) {
	    Optional<BudgetLine> bl = repository.findByAccount(account);
	    if (bl.isPresent()) {
	      return bl.get();
	    }

	    return null;
	  }

	  @PostMapping("/add")
	  public BudgetLine add(@RequestBody @NonNull BudgetLine bl) {
	    return repository.insert(bl);
	  }

	 

	  @GetMapping("/findByLevelPlan/{level}")
	  public List<BudgetLine> findByLevelPlan(@PathVariable @NonNull PlanType level) {
	    Optional<List<BudgetLine>> planLevels = repository.BudgetLine(level);
	    if (planLevels.isPresent()) {
	      return planLevels.get();
	    }

	    return ListUtils.emptyIfNull(null);
	  }

}
