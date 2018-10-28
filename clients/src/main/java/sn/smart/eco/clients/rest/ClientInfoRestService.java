package sn.smart.eco.clients.rest;

import sn.smart.eco.clients.model.ClientInfo;
import sn.smart.eco.clients.repositories.ClientInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rest/clients")
public class ClientInfoRestService {
  @Autowired
  private ClientInfoRepository repository;

  @GetMapping("/find/{name}")
  public ClientInfo find(@PathVariable @NonNull String name) {
    Optional<ClientInfo> pl = repository.findByName(name);
    if (pl.isPresent()) {
      return pl.get();
    }

    return null;
  }

  @PostMapping("/add")
  public ClientInfo add(@RequestBody @NonNull ClientInfo client) {
    return repository.save(client);
  }
}
