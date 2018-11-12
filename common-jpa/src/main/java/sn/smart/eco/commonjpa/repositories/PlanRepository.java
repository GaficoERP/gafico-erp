package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.commonjpa.model.Plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, String> {

}
