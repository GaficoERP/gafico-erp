package sn.smart.eco.commonjpa.service;

import java.util.List;

import sn.smart.eco.commonjpa.model.GaficoComponent;

public interface GaficoComponentService {
	public GaficoComponent addComponent(GaficoComponent component);

	public List<GaficoComponent> findComponentsInDefaultPack(boolean inDefaultPack);

	public GaficoComponent updateComponent(GaficoComponent component);
}
