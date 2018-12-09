package sn.smart.eco.common.mongo.repositories;

import sn.smart.eco.common.mongo.model.PlanLine;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanLineRepository extends MongoRepository<PlanLine, String> {
  Optional<PlanLine> findByCodeAndLabel(int code, String label);

  Optional<PlanLine> findByCodeAndPlan(int code, String plan);

  Optional<List<PlanLine>> findByPlan(String plan);

  Optional<List<PlanLine>> findByLevelName(String level);

  Optional<List<PlanLine>> findByPrevious(PlanLine previous);
}