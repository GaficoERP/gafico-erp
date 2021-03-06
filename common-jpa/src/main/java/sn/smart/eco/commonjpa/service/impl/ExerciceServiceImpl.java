package sn.smart.eco.commonjpa.service.impl;

import sn.smart.eco.common.model.GaficoResult;
import sn.smart.eco.common.model.GaficoStatus;
import sn.smart.eco.commonjpa.model.Exercice;
import sn.smart.eco.commonjpa.repositories.ExerciceRepository;
import sn.smart.eco.commonjpa.service.ExerciceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciceServiceImpl implements ExerciceService {
  @Autowired
  private ExerciceRepository repository;

  @Override
  public Exercice addExercice(@NonNull Exercice exo) {
    return repository.save(exo);
  }

  @Override
  public List<Exercice> findAll() {
    return repository.findAllByOrderByYearDesc();
  }

  @Override
  public GaficoResult deleteExercice(@NonNull Exercice exo) {
    GaficoResult result = new GaficoResult();
    try {
      repository.delete(exo);
      result.setStatus(GaficoStatus.SUCCESS);
    } catch (Throwable e) {
      result.setStatus(GaficoStatus.ERROR);
      result.setError(e.getMessage());
    }
    return result;
  }

  @Override
  public Exercice findCurrent() {
    Optional<Exercice> exo = repository.findFirstByOrderByYearDesc();
    if (exo.isPresent()) {
      return exo.get();
    }
    return null;
  }

  @Override
  public Exercice findByYear(@NonNull Integer year) {
    Optional<Exercice> exo = repository.findByYear(year);
    if (exo.isPresent()) {
      return exo.get();
    }
    return null;
  }

}
