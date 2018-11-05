package sn.smart.eco.commonjpa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sn.smart.eco.commonjpa.model.GaficoComponent;
import sn.smart.eco.commonjpa.repositories.GaficoComponentRepository;
import sn.smart.eco.commonjpa.service.GaficoComponentService;

@Service
public class GaficoComponentServiceImpl implements GaficoComponentService {
	@Autowired
	private GaficoComponentRepository componentRepository;

	@Override
	public GaficoComponent addComponent(@NonNull GaficoComponent component) {
		return componentRepository.save(component);
	}

	@Override
	public List<GaficoComponent> findComponentsInDefaultPack(boolean inDefaultPack) {
		Optional<List<GaficoComponent>> components = componentRepository.findByInDefaultPack(inDefaultPack);
		if (components.isPresent()) {
			return components.get();
		}

		return new ArrayList<>();
	}

	@Override
	public GaficoComponent updateComponent(@NonNull GaficoComponent component) {
		return componentRepository.save(component);
	}

}
