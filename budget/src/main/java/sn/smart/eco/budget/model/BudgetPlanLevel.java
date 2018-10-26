package sn.smart.eco.budget.model;

import sn.smart.eco.common.jpa.model.AbstractPlanLevel;
import sn.smart.eco.common.jpa.model.LevelType;
import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budget_plan_level")
public class BudgetPlanLevel extends AbstractPlanLevel {
  @DBRef
  private BudgetPlanLevel previous;
  @Indexed
  private Long code;

  public BudgetPlanLevel() {}

  public BudgetPlanLevel(String id, Long code, String label, LevelType level,
      BudgetPlanLevel previous) {
    super(id, label, level);
    this.code = code;
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

  @Override
  public Long getCode() {
    return code;
  }

  @Override
  public void setCode(Long code) {
    this.code = code;
  }
}
