package sn.smart.eco.commonjpa.repositories;

import sn.smart.eco.commonjpa.model.Exercice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Integer> {

  List<Exercice> findAllByOrderByYearDesc();

  Optional<Exercice> findFirstByOrderByYearDesc();

  Optional<Exercice> findByYear(Integer year);
}
