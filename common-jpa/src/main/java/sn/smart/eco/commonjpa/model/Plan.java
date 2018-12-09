package sn.smart.eco.commonjpa.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "common_plan")
public class Plan {
  @Id
  private String name;
  @OneToOne
  private Structuration structuration;
  private boolean isActive;
  private boolean isValidated;

  public Plan() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Structuration getStructuration() {
    return structuration;
  }

  public void setStructuration(Structuration structuration) {
    this.structuration = structuration;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  public boolean isValidated() {
    return isValidated;
  }

  public void setValidated(boolean isValidated) {
    this.isValidated = isValidated;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
