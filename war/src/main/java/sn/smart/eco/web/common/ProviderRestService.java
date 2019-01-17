package sn.smart.eco.web.common;

import sn.smart.eco.commonjpa.model.Provider;
import sn.smart.eco.commonjpa.service.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/common/provider")
public class ProviderRestService {
  @Autowired
  private ProviderService service;

  @PostMapping("/save")
  public Provider save(@RequestBody Provider provider) {
    return service.saveProvider(provider);
  }

  @GetMapping("/find/{name}")
  public Provider find(@PathVariable String name) {
    return service.findProvider(name);
  }

  @GetMapping("/findAll")
  public List<Provider> findAll() {
    return service.findAll();
  }
}
