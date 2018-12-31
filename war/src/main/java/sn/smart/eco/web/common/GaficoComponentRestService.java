package sn.smart.eco.web.common;

import sn.smart.eco.commonjpa.model.GaficoComponent;
import sn.smart.eco.commonjpa.service.GaficoComponentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/common/component")
public class GaficoComponentRestService {
  @Autowired
  private GaficoComponentService service;

  @PostMapping("/add")
  public GaficoComponent add(@RequestBody @NonNull GaficoComponent component) {
    return service.addComponent(component);
  }

  @GetMapping("/find/{inDefaultPack}")
  public List<GaficoComponent> findByInDefaultPack(@PathVariable @NonNull boolean inDefaultPack) {
    return service.findComponentsInDefaultPack(inDefaultPack);
  }

  @GetMapping("/findByName/{name}")
  public GaficoComponent findByName(@PathVariable @NonNull String name) {
    return service.findByName(name);
  }

  @PostMapping("/update")
  public GaficoComponent update(@RequestBody @NonNull GaficoComponent component) {
    return service.updateComponent(component);
  }
}
