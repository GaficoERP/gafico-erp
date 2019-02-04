package sn.smart.eco.budget.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sn.smart.eco.budget.model.Engagement;
import sn.smart.eco.budget.mongo.repositories.EngagementRepository;
import sn.smart.eco.budget.services.EngagementService;

@Service
@Transactional
public class EngagementServiceImp implements EngagementService {

	@Autowired
	private EngagementRepository repository;

	@Override
	public Engagement save(@NonNull Engagement engagement) {
		return repository.save(engagement);
	}

	@Override
	public List<Engagement> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Engagement> findByBudgetLine(@NonNull Integer budgetLine) {
		Optional<List<Engagement>> engagements = repository.findByBudgetLine(budgetLine);
		if (engagements.isPresent()) {
			return engagements.get();
		}

		return new ArrayList<>();
	}

	@Override
	public List<Engagement> saveAll(List<Engagement> engagements) {
		return repository.saveAll(engagements);
	}

	@Override
	public ResponseEntity<?> delete(@NonNull Engagement engagement) {
		Engagement savedOrder = repository.findByReference(engagement.getReference())
				.orElseThrow(() -> new RuntimeException("Erreur de Suppression"));

		repository.delete(savedOrder);

		return ResponseEntity.ok().build();
	}

}
