package sn.smart.eco.commonjpa.service;

import java.util.List;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.LevelType;

public interface LevelTypeService {
	public LevelType addLevel(LevelType lType);

	public List<LevelType> findLevelByPlan(PlanType plan);
}
