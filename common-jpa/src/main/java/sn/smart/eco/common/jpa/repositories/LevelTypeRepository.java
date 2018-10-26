package sn.smart.eco.common.jpa.repositories;

import sn.smart.eco.common.jpa.model.LevelType;
import sn.smart.eco.common.model.PlanType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LevelTypeRepository extends JpaRepository<LevelType, String> {

  Optional<List<LevelType>> findByPlan(PlanType plan);
}
