package sn.smart.eco.commonjpa.service.impl;

import sn.smart.eco.commonjpa.model.Provider;
import sn.smart.eco.commonjpa.repositories.ProviderRepository;
import sn.smart.eco.commonjpa.service.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
  @Autowired
  private ProviderRepository repository;

  @Override
  public Provider saveProvider(@NonNull Provider provider) {
    return repository.save(provider);
  }

  @Override
  public Provider findProvider(@NonNull String name) {
    return repository.findById(name).orElse(null);
  }

  @Override
  public List<Provider> findAll() {
    return repository.findAll();
  }

}
