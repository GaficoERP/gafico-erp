package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.Structuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructurationRepository extends JpaRepository<Structuration, String> {
  public Structuration findByType(PlanType type);
}
