package sn.smart.eco.clients.service.impl;

import sn.smart.eco.clients.model.Address;
import sn.smart.eco.clients.repositories.AddressRepository;
import sn.smart.eco.clients.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
  @Autowired
  private AddressRepository addressRepository;

  @Override
  public Address addAddress(@NonNull Address address) {
    return addressRepository.save(address);
  }

  @Override
  public List<Address> findAddressesByClientsNameAndActual(@NonNull String clientName,
      boolean actual) {
    Optional<List<Address>> addresses =
        addressRepository.findByClientsNameAndActual(clientName, actual);
    if (addresses.isPresent()) {
      return addresses.get();
    }

    return new ArrayList<>();
  }

  @Override
  public List<Address> findAddressesByClientsName(@NonNull String clientName) {
    Optional<List<Address>> addresses = addressRepository.findByClientsName(clientName);
    if (addresses.isPresent()) {
      return addresses.get();
    }

    return new ArrayList<>();
  }

}
