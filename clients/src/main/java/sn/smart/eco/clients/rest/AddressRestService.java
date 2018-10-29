package sn.smart.eco.clients.rest;

import sn.smart.eco.clients.model.Address;
import sn.smart.eco.clients.repositories.AddressRepository;

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
@RequestMapping("/rest/client/address")
public class AddressRestService {
  @Autowired
  private AddressRepository repository;

  @PostMapping("/add")
  public Address add(@RequestBody @NonNull Address address) {
    return repository.save(address);
  }

  @GetMapping("/find/{clientName}/{actual}")
  public List<Address> findByClientsNameAndActual(@PathVariable @NonNull String clientName,
      @PathVariable @NonNull boolean actual) {
    Optional<List<Address>> addresses = repository.findByClientsNameAndActual(clientName, actual);
    if (addresses.isPresent()) {
      return addresses.get();
    }

    return new ArrayList<>();
  }

  @GetMapping("/find/{clientName}")
  public List<Address> findByClientsName(@PathVariable @NonNull String clientName) {
    Optional<List<Address>> addresses = repository.findByClientsName(clientName);
    if (addresses.isPresent()) {
      return addresses.get();
    }

    return new ArrayList<>();
  }
}
