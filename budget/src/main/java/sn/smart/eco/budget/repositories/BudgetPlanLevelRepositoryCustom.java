package sn.smart.eco.budget.repositories;

import sn.smart.eco.common.jpa.model.LevelType;

public interface BudgetPlanLevelRepositoryCustom {

  public Long calculateNextCode(LevelType level);
}
