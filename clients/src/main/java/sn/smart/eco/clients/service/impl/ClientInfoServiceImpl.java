package sn.smart.eco.clients.service.impl;

import sn.smart.eco.clients.model.ClientInfo;
import sn.smart.eco.clients.repositories.AddressRepository;
import sn.smart.eco.clients.repositories.ClientInfoRepository;
import sn.smart.eco.clients.repositories.GaficoLicenseRepository;
import sn.smart.eco.clients.service.ClientInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {
  @Autowired
  private ClientInfoRepository ciRepository;
  @Autowired
  private AddressRepository addRepository;
  @Autowired
  private GaficoLicenseRepository licenseRepository;

  @Override
  public ClientInfo findClientInfo(@NonNull String name) {
    Optional<ClientInfo> pl = ciRepository.findByName(name);
    if (pl.isPresent()) {
      return pl.get();
    }

    return null;
  }

  @Override
  public ClientInfo addClientInfo(@NonNull ClientInfo client) {
    // ajout les addresses a la BD si elles existent pas encore
    if (client.getAddresses() != null) {
      client.getAddresses().forEach(add -> addRepository.save(add));
    }
    // ajout les licences a la BD si elles existent pas encore
    if (client.getLicenses() != null) {
      client.getLicenses().forEach(lic -> licenseRepository.save(lic));
    }
    return ciRepository.save(client);
  }

}
