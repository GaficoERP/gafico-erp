package sn.smart.eco.commonjpa.service;

import sn.smart.eco.commonjpa.model.GaficoComponent;

import java.util.List;

public interface GaficoComponentService {
  public GaficoComponent addComponent(GaficoComponent component);

  public List<GaficoComponent> findComponentsInDefaultPack(boolean inDefaultPack);

  public GaficoComponent findByName(String name);

  public GaficoComponent updateComponent(GaficoComponent component);
}
