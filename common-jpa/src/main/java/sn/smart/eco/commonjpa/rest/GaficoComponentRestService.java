package sn.smart.eco.commonjpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.smart.eco.commonjpa.model.GaficoComponent;
import sn.smart.eco.commonjpa.repositories.GaficoComponentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/common/component")
public class GaficoComponentRestService {
  @Autowired
  private GaficoComponentRepository repository;

  @PostMapping("/add")
  public GaficoComponent add(@RequestBody @NonNull GaficoComponent component) {
    return repository.save(component);
  }


  @GetMapping("/find/{inDefaultPack}")
  public List<GaficoComponent> findByInDefaultPack(@PathVariable @NonNull boolean inDefaultPack) {
    Optional<List<GaficoComponent>> addresses = repository.findByInDefaultPack(inDefaultPack);
    if (addresses.isPresent()) {
      return addresses.get();
    }

    return new ArrayList<>();
  }

  @PostMapping("/update")
  public GaficoComponent update(@RequestBody @NonNull GaficoComponent component) {
    return repository.save(component);
  }
}
