package sn.smart.eco.budget.model;

import sn.smart.eco.common.model.AbstractPlanLevel;
import sn.smart.eco.common.model.LevelType;
import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budget_plan_level")
public class BudgetPlanLevel extends AbstractPlanLevel {
  @DBRef
  private BudgetPlanLevel previous;

  public BudgetPlanLevel() {}

  public BudgetPlanLevel(String id, String code, String label, LevelType level,
      BudgetPlanLevel previous) {
    super(id, code, label, level);
    this.previous = previous;
  }

  @Override
  public BudgetPlanLevel getPrevious() {
    return previous;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
