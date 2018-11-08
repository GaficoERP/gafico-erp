package sn.smart.eco.clients.service;

import sn.smart.eco.clients.model.Address;

import java.util.List;

public interface AddressService {
  public Address addAddress(Address address);

  public List<Address> findAddressesByClientsNameAndActual(String clientName, boolean actual);

  public List<Address> findAddressesByClientsName(String clientName);
}
