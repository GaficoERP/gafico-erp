package sn.smart.eco.budget.repositories;

import sn.smart.eco.commonjpa.model.LevelType;

public interface BudgetPlanLevelRepositoryCustom {

  public Long calculateNextCode(LevelType level);
}
