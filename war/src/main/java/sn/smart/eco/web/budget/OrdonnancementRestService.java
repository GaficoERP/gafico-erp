package sn.smart.eco.web.budget;

import sn.smart.eco.budget.model.Ordonnancement;
import sn.smart.eco.budget.services.OrdonnancementService;
import sn.smart.eco.web.common.model.CodeEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/budget/order")
public class OrdonnancementRestService {

  @Autowired
  private OrdonnancementService service;

  @PostMapping("/save")
  public Ordonnancement save(@RequestBody @NonNull Ordonnancement order) {
    return service.save(order);
  }

  @PostMapping("/saveAll")
  public List<Ordonnancement> saveAll(@RequestBody @NonNull List<Ordonnancement> orders) {
    return service.saveAll(orders);
  }

  @GetMapping("/findAll")
  public List<Ordonnancement> findAll() {
    return service.findAllByGroupByEngagement();
  }

  @GetMapping("/find/{engagement}")
  public List<Ordonnancement> findByEngagement(@PathVariable @NonNull Integer engagement) {
    return service.findByEngagement(engagement);
  }

  @GetMapping("/newref/{engagement}")
  public CodeEntity getNextReferenceCode(@PathVariable @NonNull Integer engagement) {
    CodeEntity entity = new CodeEntity();
    entity.setCode(service.getNextReferenceCode(engagement));
    return entity;
  }

  @DeleteMapping("/delete")
  public ResponseEntity<?> delete(@RequestBody @NonNull Ordonnancement order) {
    return service.delete(order);
  }
}
