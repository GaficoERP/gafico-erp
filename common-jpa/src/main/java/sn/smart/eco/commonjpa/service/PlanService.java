package sn.smart.eco.commonjpa.service;

import sn.smart.eco.commonjpa.model.Plan;

import java.util.List;

public interface PlanService {

  public Plan addPlan(Plan plan);

  public Plan findPlan(String name);

  public Plan updatePlan(Plan plan);

  public List<Plan> findAll();

  public String findDeeperLevelName(String plan);
}
