package sn.smart.eco.budget.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import sn.smart.eco.budget.model.Engagement;

public interface EngagementService {

	Engagement save(Engagement engagement);

	List<Engagement> saveAll(List<Engagement> engagements);

	List<Engagement> findByBudgetLine(Integer budgetLine);

	ResponseEntity<?> delete(Engagement engagement);

}
