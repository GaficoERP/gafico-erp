package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.LevelType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LevelTypeRepository extends JpaRepository<LevelType, String> {

  Optional<List<LevelType>> findByPlan(PlanType plan);
}
