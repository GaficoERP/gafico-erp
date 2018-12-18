package sn.smart.eco.web.common.model;

import sn.smart.eco.common.mongo.model.PlanLine;
import sn.smart.eco.commonjpa.model.Plan;

import java.util.List;

public class PlanResponse {

  private Plan plan;
  private List<PlanLine> planLines;

  public Plan getPlan() {
    return plan;
  }

  public void setPlan(Plan plan) {
    this.plan = plan;
  }

  public List<PlanLine> getPlanLines() {
    return planLines;
  }

  public void setPlanLines(List<PlanLine> planLines) {
    this.planLines = planLines;
  }


}
