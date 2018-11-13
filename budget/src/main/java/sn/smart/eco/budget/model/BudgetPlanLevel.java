package sn.smart.eco.budget.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budget_plan_level")
@Deprecated
public class BudgetPlanLevel /* extends AbstractPlanLevel */ {
  // @DBRef
  // private BudgetPlanLevel previous;
  // @Indexed
  // private Long code;
  //
  // public BudgetPlanLevel() {}
  //
  // public BudgetPlanLevel(String id, Long code, String label, LevelType level,
  // BudgetPlanLevel previous) {
  // super(id, label, level);
  // this.code = code;
  // this.previous = previous;
  // }
  //
  // @Override
  // public BudgetPlanLevel getPrevious() {
  // return previous;
  // }
  //
  // @Override
  // public String toString() {
  // return GaficoCommonUtils.toJsonString(this);
  // }
  //
  // @Override
  // public Long getCode() {
  // return code;
  // }
  //
  // @Override
  // public void setCode(Long code) {
  // this.code = code;
  // }
}
