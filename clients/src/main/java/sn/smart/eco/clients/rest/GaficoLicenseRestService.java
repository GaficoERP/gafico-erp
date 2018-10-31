package sn.smart.eco.clients.rest;

import sn.smart.eco.clients.model.GaficoLicense;
import sn.smart.eco.clients.repositories.GaficoLicenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/client/license")
public class GaficoLicenseRestService {
  @Autowired
  private GaficoLicenseRepository repository;

  @PostMapping("/add")
  public GaficoLicense add(@RequestBody @NonNull GaficoLicense license) {
    return repository.save(license);
  }

  @GetMapping("/find/{ownerName}")
  public List<GaficoLicense> findByOwnerName(@PathVariable @NonNull String ownerName) {
    Optional<List<GaficoLicense>> licenses = repository.findByOwnerName(ownerName);
    if (licenses.isPresent()) {
      return licenses.get();
    }

    return new ArrayList<>();
  }

  @GetMapping("/find/{compName}")
  public List<GaficoLicense> findByComponentsName(@PathVariable @NonNull String compName) {
    Optional<List<GaficoLicense>> licenses = repository.findByComponentsName(compName);
    if (licenses.isPresent()) {
      return licenses.get();
    }

    return new ArrayList<>();
  }
}
