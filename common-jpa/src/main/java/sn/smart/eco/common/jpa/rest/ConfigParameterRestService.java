package sn.smart.eco.common.jpa.rest;

import sn.smart.eco.common.jpa.model.ConfigParameter;
import sn.smart.eco.common.jpa.utils.ConfigParameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/common/config")
public class ConfigParameterRestService {

  @Autowired
  private ConfigParameters configParams;

  @PostMapping("/add")
  public ConfigParameter add(@RequestBody @NonNull ConfigParameter conf) {
    return configParams.addParameter(conf);
  }

  @GetMapping("/find/{paramName}")
  public ConfigParameter find(@PathVariable @NonNull String paramName) {
    return configParams.getParameter(paramName);
  }

  @DeleteMapping("/del/{paramName}")
  public ConfigParameter delete(@PathVariable @NonNull String paramName) {
    return configParams.removeParameter(paramName);
  }
}
