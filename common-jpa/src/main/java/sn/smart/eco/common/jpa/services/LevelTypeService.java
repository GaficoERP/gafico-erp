package sn.smart.eco.common.jpa.services;

import sn.smart.eco.common.jpa.model.LevelType;
import sn.smart.eco.common.jpa.repositories.LevelTypeRepository;
import sn.smart.eco.common.model.PlanType;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/common")
public class LevelTypeService {

  @Autowired
  private LevelTypeRepository repository;

  @PostMapping("/add")
  public LevelType add(@RequestBody @NonNull LevelType lType) {
    return repository.save(lType);
  }

  @GetMapping("/findByPlan/{plan}")
  public List<LevelType> findByPlan(@PathVariable("plan") @NonNull PlanType plan) {
    Optional<List<LevelType>> optLevelType = repository.findByPlan(plan);
    if (optLevelType.isPresent()) {
      return optLevelType.get();
    }

    return ListUtils.emptyIfNull(null);
  }
}
