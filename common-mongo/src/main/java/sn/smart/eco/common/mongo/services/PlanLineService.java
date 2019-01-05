package sn.smart.eco.common.mongo.services;

import sn.smart.eco.common.model.GaficoResult;
import sn.smart.eco.common.mongo.model.PlanLine;

import java.util.List;

public interface PlanLineService {
  public PlanLine addPlanLine(PlanLine pl);

  public PlanLine findByCodeAndLabel(String code, String label);

  public PlanLine findByCodeAndPlan(String code, String plan);

  public List<PlanLine> findByPlan(String plan);

  public List<PlanLine> findByLevelNameAndPlan(String level, String plan);

  public List<PlanLine> findByPreviousCodeAndPlan(String previousCode, String plan);

  public GaficoResult deletePlanLine(PlanLine planLine);

  public String getNewCode(String levelName, int levelCodeSize, String plan, String previous);

  public List<PlanLine> addAll(List<PlanLine> lines);
}
