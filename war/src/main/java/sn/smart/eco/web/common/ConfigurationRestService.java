package sn.smart.eco.web.common;

import sn.smart.eco.common.mongo.model.PlanLine;
import sn.smart.eco.common.mongo.services.PlanLineService;
import sn.smart.eco.commonjpa.model.Plan;
import sn.smart.eco.commonjpa.service.PlanService;
import sn.smart.eco.web.common.model.PlanResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/common/config")
public class ConfigurationRestService {
  @Autowired
  private PlanService planService;
  @Autowired
  private PlanLineService pLineService;

  @PostMapping("/addPlanWithLines")
  public PlanResponse addPlanWithLines(@RequestBody @NonNull Plan plan, @RequestBody @NonNull List<PlanLine> lines) {
    Plan savedPlan = planService.addPlan(plan);
    lines.forEach(l -> l.setPlan(savedPlan.getName()));
    List<PlanLine> savedLines = pLineService.addAll(lines);

    PlanResponse response = new PlanResponse();
    response.setPlan(savedPlan);
    response.setPlanLines(savedLines);

    return response;
  }
}
