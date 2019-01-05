package sn.smart.eco.common.mongo.services.impl;

import sn.smart.eco.common.model.GaficoResult;
import sn.smart.eco.common.mongo.model.PlanLine;
import sn.smart.eco.common.mongo.repositories.PlanLineRepository;
import sn.smart.eco.common.mongo.services.PlanLineService;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanLineServiceImpl implements PlanLineService {
  @Autowired
  private PlanLineRepository plRepository;

  @Override
  public PlanLine findByCodeAndLabel(String code, @NonNull String label) {
    Optional<PlanLine> pLine = plRepository.findByCodeAndLabel(code, label);
    if (pLine.isPresent()) {
      return pLine.get();
    }

    return null;
  }

  @Override
  public PlanLine findByCodeAndPlan(String code, @NonNull String plan) {
    Optional<PlanLine> pLine = plRepository.findByCodeAndPlan(code, plan);
    if (pLine.isPresent()) {
      return pLine.get();
    }

    return null;
  }

  @Override
  public List<PlanLine> findByPlan(@NonNull String plan) {
    Optional<List<PlanLine>> pLines = plRepository.findByPlan(plan);
    if (pLines.isPresent()) {
      return pLines.get();
    }

    return ListUtils.emptyIfNull(null);
  }

  @Override
  public List<PlanLine> findByLevelNameAndPlan(@NonNull String level, @NonNull String plan) {
    Optional<List<PlanLine>> pLines =
        plRepository.findByLevelNameAndPlanOrderByCodeAsc(level, plan);
    if (pLines.isPresent()) {
      return pLines.get();
    }

    return ListUtils.emptyIfNull(null);
  }

  @Override
  public List<PlanLine> findByPreviousCodeAndPlan(@NonNull String previous, @NonNull String plan) {
    // Optional<List<PlanLine>> pLines =
    // plRepository.findByPreviousCodeAndPlanOrderByCodeDesc(previous, plan);
    // if (pLines.isPresent()) {
    // return pLines.get();
    // }

    // FIXME
    return ListUtils.emptyIfNull(null);
  }

  @Override
  public GaficoResult deletePlanLine(@NonNull PlanLine planLine) {
    // FIXME
    return null;
  }

  @Override
  public String getNewCode(@NonNull String levelName, int levelCodeSize, String plan,
      String previous) {
    // Optional<PlanLine> pLine;

    // if (previous == null) {
    Optional<PlanLine> pLine = plRepository.findFirstByLevelNameAndPlanAndCodeStartsWith(levelName,
        plan, previous, new Sort(Sort.Direction.DESC, "code"));
    if (pLine.isPresent()) {
      Integer newCode = Integer.parseInt(pLine.get().getCode()) + 1;
      return String.valueOf(newCode);
    }
    return StringUtils.leftPad("1", levelCodeSize - 1, "0");
    // } else {
    // // FIXME à corriger
    // // pLines = plRepository.findByPreviousOrderByCodeDesc(previous);
    // if (false/* pLines.isPresent() */) {
    // Integer newCode = Integer.parseInt(pLines.get().get(0).getCode()) + 1;
    // return String.valueOf(newCode);
    // } else {
    // // codePrevious * (10^tailleCode[level]) + 1
    // double pow = Math.pow(10, levelCodeSize);
    // double newCode = pow * Integer.parseInt(previous.getCode()) + 1;
    // return String.valueOf(newCode);
    // }
    // }
  }

  @Override
  public PlanLine addPlanLine(PlanLine pl) {
    return plRepository.save(pl);
  }

  @Override
  public List<PlanLine> addAll(@NonNull List<PlanLine> lines) {
    return plRepository.saveAll(lines);
  }

}
