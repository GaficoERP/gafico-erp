package sn.smart.eco.common.mongo.repositories;

import sn.smart.eco.common.mongo.model.PlanLine;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanLineRepository extends MongoRepository<PlanLine, String> {
  Optional<PlanLine> findByCodeAndLabel(String code, String label);

  Optional<PlanLine> findByCodeAndPlan(String code, String plan);

  Optional<List<PlanLine>> findByPlan(String plan);

  Optional<List<PlanLine>> findByLevelNameAndPlanOrderByCodeAsc(String level, String plan);

  Optional<List<PlanLine>> findByLevelNameAndPlanOrderByCodeDesc(String levelName, String plan);

  Optional<PlanLine> findFirstByLevelNameAndPlanAndCodeStartsWith(String levelName, String plan,
      String previous, Sort sort);

  // Optional<List<PlanLine>> findByPreviousCodeAndPlanOrderByCodeDesc(String previousCode,
  // String plan);
  //
  // Optional<List<PlanLine>> findByPreviousOrderByCodeDesc(PlanLine previous);
}
