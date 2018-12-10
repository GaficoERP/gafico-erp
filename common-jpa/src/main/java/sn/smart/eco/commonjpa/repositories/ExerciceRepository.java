package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.commonjpa.model.Exercice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Integer> {

}
