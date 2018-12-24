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
  // @Autowired
  // private StructurationService structService;

  @Override
  public Plan addPlan(@NonNull Plan plan) {
    // structService.addStructuration(plan.getStructuration());
    return planRepository.save(plan);
  }

  @Override
  public Plan findPlan(@NonNull String name) {
    return planRepository.getOne(name);
  }

  @Override
  public Plan updatePlan(@NonNull Plan plan) {
    return planRepository.save(plan);
  }

  @Override
  public List<Plan> findAll() {
    return planRepository.findAll();
  }

}
