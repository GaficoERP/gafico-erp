package sn.smart.eco.commonjpa.service;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.LevelType;

import java.util.List;

@Deprecated
public interface LevelTypeService {
  public LevelType addLevel(LevelType lType);

  public List<LevelType> findLevelByPlan(PlanType plan);
}
