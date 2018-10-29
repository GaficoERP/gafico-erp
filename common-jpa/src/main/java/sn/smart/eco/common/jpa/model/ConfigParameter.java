package sn.smart.eco.common.jpa.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "common_config_param")
@SuppressWarnings("rawtypes")
public class ConfigParameter {

  @Id
  private String name;
  private String value;
  @OneToOne
  @JoinTable(name = "common_config_param_component", joinColumns = @JoinColumn(name = "name"),
      inverseJoinColumns = @JoinColumn(name = "comp_id"))
  private GaficoComponent component;
  private Boolean isActive;
  private Class valueClass;

  public ConfigParameter() {}

  public ConfigParameter(@NonNull String name, @NonNull String value,
      @NonNull GaficoComponent component, Boolean isActive, Class valueClass) {
    super();
    this.name = name;
    this.value = value;
    this.component = component;
    this.isActive = isActive == null ? Boolean.FALSE : isActive;
    this.valueClass = valueClass;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public GaficoComponent getComponent() {
    return component;
  }

  public void setComponent(GaficoComponent component) {
    this.component = component;
  }

  public Boolean isActive() {
    return isActive;
  }

  public void setActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public void setValueClass(Class valueClass) {
    this.valueClass = valueClass;
  }

  public Class getValueClass() {
    return valueClass;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
