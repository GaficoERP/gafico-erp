package sn.smart.eco.budget.repositories;

import sn.smart.eco.budget.model.BudgetPlanLevel;
import sn.smart.eco.common.model.PlanType;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetPlanLevelRepository
    extends MongoRepository<BudgetPlanLevel, String>, BudgetPlanLevelRepositoryCustom {
  Optional<BudgetPlanLevel> findByCode(Long code);

  Optional<List<BudgetPlanLevel>> findByPrevious(BudgetPlanLevel previous);

  Optional<List<BudgetPlanLevel>> findByLevelPlan(PlanType level);
}
