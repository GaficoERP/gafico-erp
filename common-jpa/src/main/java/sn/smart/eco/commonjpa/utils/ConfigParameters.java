package sn.smart.eco.commonjpa.utils;

import sn.smart.eco.commonjpa.model.ConfigParameter;
import sn.smart.eco.commonjpa.repositories.ConfigParameterRepository;
import sn.smart.eco.commonjpa.repositories.GaficoComponentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

@Service
public final class ConfigParameters {

  private final Map<String, ConfigParameter> parameters = new HashMap<>();
  @Autowired
  private ConfigParameterRepository configRepository;
  @Autowired
  private GaficoComponentRepository componentRepository;

  @PostConstruct
  public void loadParameters() {
    Optional<List<ConfigParameter>> params = configRepository.findByComponentInDefaultPack(true);
    if (params.isPresent()) {
      saveAll(params.get());
    }
  }

  public ConfigParameter getParameter(@NonNull String confName) {
    return parameters.get(confName);
  }

  public ConfigParameter addParameter(@NonNull ConfigParameter param) {
    if (!componentRepository.existsById(param.getComponent().getName())) {
      componentRepository.save(param.getComponent());
    }
    parameters.put(param.getName(), param);
    return configRepository.save(param);
  }

  public boolean isValueTrue(@NonNull String name) {
    ConfigParameter param = getParameter(name);
    if (param != null && Boolean.class.equals(param.getValueClass())) {
      return Boolean.parseBoolean(param.getValue());
    }

    return Boolean.FALSE;
  }

  public void saveAll(@NonNull List<ConfigParameter> confParams) {
    parameters.putAll(confParams.stream().collect(Collectors.toMap(x -> x.getName(), x -> x)));
    configRepository.saveAll(confParams);
  }

  public ConfigParameter removeParameter(@NonNull String param) {
    return parameters.remove(param);
  }
}
