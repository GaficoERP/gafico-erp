package sn.smart.eco.web.client;

import sn.smart.eco.clients.model.Address;
import sn.smart.eco.clients.service.AddressService;

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
@RequestMapping("/rest/client/address")
public class AddressRestService {
  @Autowired
  private AddressService service;

  @PostMapping("/add")
  public Address add(@RequestBody @NonNull Address address) {
    return service.addAddress(address);
  }

  @GetMapping("/find/{clientName}/{actual}")
  public List<Address> findByClientsNameAndActual(@PathVariable @NonNull String clientName,
      @PathVariable @NonNull boolean actual) {
    return service.findAddressesByClientsNameAndActual(clientName, actual);
  }

  @GetMapping("/find/{clientName}")
  public List<Address> findByClientsName(@PathVariable @NonNull String clientName) {
    return service.findAddressesByClientsName(clientName);
  }
}
