package sn.smart.eco.commonjpa.service.impl;

import sn.smart.eco.commonjpa.model.Plan;
import sn.smart.eco.commonjpa.repositories.PlanRepository;
import sn.smart.eco.commonjpa.service.PlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
  @Autowired
  private PlanRepository planRepository;

  @Override
  public Plan addPlan(@NonNull Plan plan) {
    return planRepository.save(plan);
  }

  @Override
  public Plan findPlan(@NonNull String name) {
    return planRepository.findById(name).orElse(null);
  }

  @Override
  public Plan updatePlan(@NonNull Plan plan) {
    return planRepository.save(plan);
  }

  @Override
  public List<Plan> findAll() {
    return planRepository.findAll();
  }

  @Override
  public String findDeeperLevelName(String planName) {
    Plan plan = findPlan(planName);
    int last = plan.getStructuration().size() - 1;
    return plan.getStructuration().get(last).getName();
  }

}
