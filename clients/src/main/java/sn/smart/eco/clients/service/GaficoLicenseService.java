package sn.smart.eco.clients.service;

import sn.smart.eco.clients.model.GaficoLicense;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GaficoLicenseService {
  public GaficoLicense addLicense(@RequestBody @NonNull GaficoLicense license);

  public List<GaficoLicense> findLicensesByOwnerName(@PathVariable @NonNull String ownerName);

  public List<GaficoLicense> findLicensesByComponentsName(@PathVariable @NonNull String compName);
}
