package sn.smart.eco.commonjpa.service.impl;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.LevelType;
import sn.smart.eco.commonjpa.repositories.LevelTypeRepository;
import sn.smart.eco.commonjpa.service.LevelTypeService;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

// @Service
@Deprecated
public class LevelTypeServiceImpl implements LevelTypeService {
  @Autowired
  private LevelTypeRepository levelRepository;

  @Override
  public LevelType addLevel(@NonNull LevelType lType) {
    return levelRepository.save(lType);
  }

  @Override
  public List<LevelType> findLevelByPlan(PlanType plan) {
    Optional<List<LevelType>> optLevelType = levelRepository.findByPlan(plan);
    if (optLevelType.isPresent()) {
      return optLevelType.get();
    }

    return ListUtils.emptyIfNull(null);
  }

}
