package sn.smart.eco.commonjpa.service;

import sn.smart.eco.common.model.GaficoResult;
import sn.smart.eco.commonjpa.model.Exercice;

import java.util.List;

public interface ExerciceService {

  public Exercice addExercice(Exercice exo);

  public List<Exercice> findAll();

  public GaficoResult deleteExercice(Exercice exo);

  public Exercice findCurrent();
}
