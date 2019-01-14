package sn.smart.eco.web.common;

import sn.smart.eco.commonjpa.model.ConfigParameter;
import sn.smart.eco.commonjpa.model.Plan;
import sn.smart.eco.commonjpa.service.PlanService;
import sn.smart.eco.commonjpa.utils.ConfigParameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// @CrossOrigin
@RequestMapping("/rest/common/plan")
public class PlanRestService {

  @Autowired
  private PlanService planService;
  @Autowired
  private ConfigParameters configParams;

  @PostMapping("/add")
  public Plan addPlan(@RequestBody @NonNull Plan plan) {
    return planService.addPlan(plan);
  }

  @GetMapping("/findPlan/{name}")
  public Plan findPlan(@PathVariable @NonNull String name) {
    return planService.findPlan(name);
  }

  @GetMapping("/find")
  public Plan findCurrent() {
    ConfigParameter plan = configParams.getParameter("config.budget.plan");
    return planService.findPlan(plan.getValue());
  }

  @PostMapping("/update")
  public Plan updatePlan(@RequestBody @NonNull Plan plan) {
    return planService.updatePlan(plan);
  }

  @GetMapping("/findAll")
  public List<Plan> findAll() {
    return planService.findAll();
  }
}
