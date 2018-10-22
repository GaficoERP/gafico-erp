package sn.smart.eco.budget.services;

import sn.smart.eco.budget.model.BudgetPlanLevel;
import sn.smart.eco.budget.repositories.BudgetPlanLevelRepository;
import sn.smart.eco.common.model.PlanType;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/budget")
public class BudgetPlanLevelService {

  @Autowired
  private BudgetPlanLevelRepository repository;

  @GetMapping("/find/{code}")
  public BudgetPlanLevel findBudgetPlanLevel(@PathVariable @NonNull String code) {
    Optional<BudgetPlanLevel> pl = repository.findByCode(code);
    if (pl.isPresent()) {
      return pl.get();
    }

    return null;
  }

  @PostMapping("/add")
  public BudgetPlanLevel add(@RequestBody @NonNull BudgetPlanLevel bpl) {
    return repository.insert(bpl);
  }

  @GetMapping("/findByPrevious")
  public List<BudgetPlanLevel> findByPrevious(@RequestBody @NonNull BudgetPlanLevel previous) {
    Optional<List<BudgetPlanLevel>> planLevels = repository.findByPrevious(previous);
    if (planLevels.isPresent()) {
      return planLevels.get();
    }

    return ListUtils.emptyIfNull(null);
  }

  @GetMapping("/findByLevelPlan/{level}")
  public List<BudgetPlanLevel> findByLevelPlan(@PathVariable @NonNull PlanType level) {
    Optional<List<BudgetPlanLevel>> planLevels = repository.findByLevelPlan(level);
    if (planLevels.isPresent()) {
      return planLevels.get();
    }

    return ListUtils.emptyIfNull(null);
  }
}
