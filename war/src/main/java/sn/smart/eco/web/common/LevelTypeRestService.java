package sn.smart.eco.web.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.LevelType;
import sn.smart.eco.commonjpa.service.LevelTypeService;

@RestController
@RequestMapping("/rest/common/level")
public class LevelTypeRestService {

	@Autowired
	private LevelTypeService service;

	@PostMapping("/add")
	public LevelType add(@RequestBody @NonNull LevelType lType) {
		return service.addLevel(lType);
	}

	@GetMapping("/findByPlan/{plan}")
	public List<LevelType> findByPlan(@PathVariable("plan") @NonNull PlanType plan) {
		return service.findLevelByPlan(plan);
	}
}
