package sn.smart.eco.common.mongo.repositories;

import sn.smart.eco.common.mongo.model.PlanLine;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanLineRepository extends MongoRepository<PlanLine, String> {
  Optional<PlanLine> findByCodeAndLabel(String code, String label);

  Optional<PlanLine> findByCodeAndPlan(String code, String plan);

  Optional<List<PlanLine>> findByPlan(String plan);

  Optional<List<PlanLine>> findByLevelNameAndPlanOrderByCodeDesc(String level, String plan);

  // Optional<List<PlanLine>> findByPreviousCodeAndPlanOrderByCodeDesc(String previousCode,
  // String plan);
  //
  // Optional<List<PlanLine>> findByPreviousOrderByCodeDesc(PlanLine previous);
}
