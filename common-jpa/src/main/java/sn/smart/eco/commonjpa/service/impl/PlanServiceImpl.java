package sn.smart.eco.commonjpa.service.impl;

import sn.smart.eco.commonjpa.model.Plan;
import sn.smart.eco.commonjpa.repositories.PlanRepository;
import sn.smart.eco.commonjpa.service.PlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {
  @Autowired
  private PlanRepository planRepository;

  @Override
  public Plan addPlan(@NonNull Plan plan) {
    return null;
  }

  @Override
  public Plan findPlan(@NonNull String name) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Plan updatePlan(@NonNull Plan plan) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Plan addPlanId(String planId) {
    // TODO Auto-generated method stub
    return null;
  }

}
