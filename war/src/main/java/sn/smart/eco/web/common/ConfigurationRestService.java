package sn.smart.eco.web.common;

import sn.smart.eco.common.mongo.model.PlanLine;
import sn.smart.eco.common.mongo.services.PlanLineService;
import sn.smart.eco.commonjpa.model.Plan;
import sn.smart.eco.commonjpa.service.PlanService;
import sn.smart.eco.web.common.model.PlanEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/rest/common/config")
@Transactional
public class ConfigurationRestService {
  @Autowired
  private PlanService planService;
  @Autowired
  private PlanLineService pLineService;

  @PostMapping("/addPlanWithLines")
  public PlanEntity addPlanWithLines(@RequestBody @NonNull PlanEntity entity) {
    Plan savedPlan = planService.addPlan(entity.getPlan());
    entity.getPlanLines().forEach(l -> l.setPlan(savedPlan.getName()));
    List<PlanLine> savedLines = pLineService.addAll(entity.getPlanLines());

    PlanEntity response = new PlanEntity();
    response.setPlan(savedPlan);
    response.setPlanLines(savedLines);

    return response;
  }
}
