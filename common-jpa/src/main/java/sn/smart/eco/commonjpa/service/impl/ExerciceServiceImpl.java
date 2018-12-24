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

}
