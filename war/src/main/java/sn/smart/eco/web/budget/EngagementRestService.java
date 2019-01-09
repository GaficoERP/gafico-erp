package sn.smart.eco.web.budget;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.smart.eco.budget.model.Engagement;
import sn.smart.eco.budget.services.EngagementService;

@RestController
@RequestMapping("/rest/budget/engagement")
public class EngagementRestService {

	@Autowired
	private EngagementService service;

	@PostMapping("/save")
	public Engagement save(@RequestBody @NonNull Engagement engagement) {
		return service.save(engagement);
	}

	@PostMapping("/saveAll")
	public List<Engagement> saveAll(@RequestBody @NonNull List<Engagement> engagements) {
		return service.saveAll(engagements);
	}

	@GetMapping("/find/{budjetline}")
	public List<Engagement> findByBudgetLine(@PathVariable @NonNull Integer budgetLine) {
		return service.findByBudgetLine(budgetLine);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody @NonNull Engagement order) {
		return service.delete(order);
	}

}
