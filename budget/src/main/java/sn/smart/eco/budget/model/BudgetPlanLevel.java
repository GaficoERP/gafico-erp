package sn.smart.eco.budget.model;

import sn.smart.eco.common.model.LevelType;
import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budget_plan_level")
public class BudgetPlanLevel {
  @Id
  private String id;
  private String code;
  private String label;
  private LevelType level;
  @DBRef
  private BudgetPlanLevel previous;

  public BudgetPlanLevel() {}

  public BudgetPlanLevel(String id, String code, String label, LevelType level,
      BudgetPlanLevel previous) {
    this.id = id;
    this.code = code;
    this.label = label;
    this.level = level;
    this.previous = previous;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public LevelType getLevel() {
    return level;
  }

  public void setLevel(LevelType level) {
    this.level = level;
  }

  public BudgetPlanLevel getPrevious() {
    return previous;
  }

  public void setPrevious(BudgetPlanLevel previous) {
    this.previous = previous;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
