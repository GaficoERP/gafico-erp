package sn.smart.eco.commonjpa.service;

import sn.smart.eco.commonjpa.model.Plan;

public interface PlanService {

  public Plan addPlan(Plan plan);

  public Plan findPlan(String name);

  public Plan updatePlan(Plan plan);

  public Plan addPlanId(String planId);
}
