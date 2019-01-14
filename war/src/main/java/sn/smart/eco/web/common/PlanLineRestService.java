package sn.smart.eco.web.common;

import sn.smart.eco.common.model.GaficoResult;
import sn.smart.eco.common.mongo.model.PlanLine;
import sn.smart.eco.common.mongo.services.PlanLineService;
import sn.smart.eco.commonjpa.model.ConfigParameter;
import sn.smart.eco.commonjpa.service.PlanService;
import sn.smart.eco.commonjpa.utils.ConfigParameters;
import sn.smart.eco.web.common.model.CodeEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/common/planline")
public class PlanLineRestService {
  @Autowired
  private PlanLineService plService;
  @Autowired
  private PlanService planService;
  @Autowired
  private ConfigParameters configParams;

  @PostMapping("/add")
  public PlanLine addPlanLine(@RequestBody @NonNull PlanLine pl) {
    return plService.addPlanLine(pl);
  }

  @GetMapping("/findByCodeAndLabel/{code}/{label}")
  public PlanLine findByCodeAndLabel(@PathVariable @NonNull String code,
      @PathVariable @NonNull String label) {
    return plService.findByCodeAndLabel(code, label);
  }

  @GetMapping("/findByCodeAndPlan/{code}/{plan}")
  public PlanLine findByCodeAndPlan(@PathVariable @NonNull String code,
      @PathVariable @NonNull String plan) {
    return plService.findByCodeAndPlan(code, plan);
  }

  @GetMapping("/findByPlan/{plan}")
  public List<PlanLine> findByPlan(@PathVariable @NonNull String plan) {
    return plService.findByPlan(plan);
  }

  @GetMapping("/find")
  public List<PlanLine> findCurrent() {
    ConfigParameter plan = configParams.getParameter("config.budget.plan");
    return plService.findByPlan(plan.getValue());
  }

  @GetMapping("/findDeepersByPlan/{plan}")
  public List<PlanLine> findDeepersByPlan(@PathVariable @NonNull String plan) {
    String levelName = planService.findDeeperLevelName(plan);
    return plService.findByLevelNameAndPlan(levelName, plan);
  }

  @GetMapping("/findByLevelNameAndPlan/{level}/{plan}")
  public List<PlanLine> findByLevelNameAndPlan(@PathVariable @NonNull String level,
      @PathVariable @NonNull String plan) {
    return plService.findByLevelNameAndPlan(level, plan);
  }

  @GetMapping("/findByPreviousCodeAndPlan/{previousCode}/{plan}")
  public List<PlanLine> findByPreviousCodeAndPlan(@PathVariable @NonNull String previousCode,
      @PathVariable @NonNull String plan) {
    return plService.findByPreviousCodeAndPlan(previousCode, plan);
  }

  @DeleteMapping("/delete")
  public GaficoResult deletePlanLine(@RequestBody @NonNull PlanLine planLine) {
    return plService.deletePlanLine(planLine);
  }

  @GetMapping("/newCode/{levelName}/{levelCodeSize}/{plan}/{previous}")
  public CodeEntity getNewCode(@PathVariable @NonNull String levelName,
      @PathVariable @NonNull int levelCodeSize, @PathVariable @NonNull String plan,
      @PathVariable @NonNull String previous) {
    CodeEntity entity = new CodeEntity();
    entity.setCode(plService.getNewCode(levelName, levelCodeSize, plan, previous));
    return entity;
  }
}
