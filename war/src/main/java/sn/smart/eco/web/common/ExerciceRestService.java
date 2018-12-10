package sn.smart.eco.web.common;

import sn.smart.eco.common.model.GaficoResult;
import sn.smart.eco.commonjpa.model.Exercice;
import sn.smart.eco.commonjpa.service.ExerciceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/common/exercice")
public class ExerciceRestService {

  @Autowired
  private ExerciceService exoService;

  @PostMapping("/add")
  public Exercice addExercice(@RequestBody @NonNull Exercice exo) {
    return exoService.addExercice(exo);
  }

  @GetMapping("/findAll")
  public List<Exercice> findAll() {
    return exoService.findAll();
  }

  @DeleteMapping("/delete")
  public GaficoResult deleteExercice(@RequestBody @NonNull Exercice exo) {
    return exoService.deleteExercice(exo);
  }
}
