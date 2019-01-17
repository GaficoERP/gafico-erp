package sn.smart.eco.commonjpa.service;

import sn.smart.eco.commonjpa.model.Provider;

import java.util.List;

public interface ProviderService {

  public Provider saveProvider(Provider provider);

  public Provider findProvider(String name);

  public List<Provider> findAll();
}
