package sn.smart.eco.clients.service.impl;

import sn.smart.eco.clients.model.GaficoLicense;
import sn.smart.eco.clients.repositories.GaficoLicenseRepository;
import sn.smart.eco.clients.service.GaficoLicenseService;
import sn.smart.eco.commonjpa.repositories.GaficoComponentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GaficoLicenseServiceImpl implements GaficoLicenseService {
  @Autowired
  private GaficoLicenseRepository licenseRepository;
  @Autowired
  private GaficoComponentRepository componentRepository;

  @Override
  public GaficoLicense addLicense(@NonNull GaficoLicense license) {
    if (license.getComponents() != null) {
      license.getComponents().forEach(comp -> componentRepository.save(comp));
    }
    return licenseRepository.save(license);
  }

  @Override
  public List<GaficoLicense> findLicensesByOwnerName(String ownerName) {
    Optional<List<GaficoLicense>> licenses = licenseRepository.findByOwnerName(ownerName);
    if (licenses.isPresent()) {
      return licenses.get();
    }

    return new ArrayList<>();
  }

  @Override
  public List<GaficoLicense> findLicensesByComponentsName(String compName) {
    Optional<List<GaficoLicense>> licenses = licenseRepository.findByComponentsName(compName);
    if (licenses.isPresent()) {
      return licenses.get();
    }

    return new ArrayList<>();
  }

}
