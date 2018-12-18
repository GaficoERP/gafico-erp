package sn.smart.eco.common.mongo.services.impl;

import sn.smart.eco.common.model.GaficoResult;
import sn.smart.eco.common.mongo.model.PlanLine;
import sn.smart.eco.common.mongo.repositories.PlanLineRepository;
import sn.smart.eco.common.mongo.services.PlanLineService;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanLineServiceImpl implements PlanLineService {
  @Autowired
  private PlanLineRepository plRepository;

  @Override
  public PlanLine findByCodeAndLabel(int code, @NonNull String label) {
    Optional<PlanLine> pLine = plRepository.findByCodeAndLabel(code, label);
    if (pLine.isPresent()) {
      return pLine.get();
    }

    return null;
  }

  @Override
  public PlanLine findByCodeAndPlan(int code, @NonNull String plan) {
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
        plRepository.findByLevelNameAndPlanOrderByCodeDesc(level, plan);
    if (pLines.isPresent()) {
      return pLines.get();
    }

    return ListUtils.emptyIfNull(null);
  }

  @Override
  public List<PlanLine> findByPreviousCodeAndPlan(@NonNull Integer previous, @NonNull String plan) {
    Optional<List<PlanLine>> pLines =
        plRepository.findByPreviousCodeAndPlanOrderByCodeDesc(previous, plan);
    if (pLines.isPresent()) {
      return pLines.get();
    }

    return ListUtils.emptyIfNull(null);
  }

  @Override
  public GaficoResult deletePlanLine(@NonNull PlanLine planLine) {
    // FIXME
    return null;
  }

  @Override
  public String getNewCode(@NonNull String levelName, int levelCodeSize, String plan,
      PlanLine previous) {
    Optional<List<PlanLine>> pLines;

    if (previous == null) {
      pLines = plRepository.findByLevelNameAndPlanOrderByCodeDesc(levelName, plan);
      if (pLines.isPresent() && CollectionUtils.isNotEmpty(pLines.get())) {
        Integer newCode = pLines.get().get(0).getCode() + 1;
        return String.valueOf(newCode);
      }
      return new String("1");
    } else {
      pLines = plRepository.findByPreviousOrderByCodeDesc(previous);
      if (pLines.isPresent()) {
        Integer newCode = pLines.get().get(0).getCode() + 1;
        return String.valueOf(newCode);
      } else {
        // codePrevious * (10^tailleCode[level]) + 1
        double pow = Math.pow(10, levelCodeSize);
        double newCode = pow * previous.getCode() + 1;
        return String.valueOf(newCode);
      }
    }
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
