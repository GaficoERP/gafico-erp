package sn.smart.eco.commonjpa.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "common_plan")
public class Plan {
  @Id
  private String name;
  // @OneToOne // (cascade = CascadeType.ALL)
  // private Structuration structuration;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Level> structuration;
  private boolean isActive;
  private boolean isValidated;

  public Plan() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Level> getStructuration() {
    if (CollectionUtils.isEmpty(structuration)) {
      structuration = new ArrayList<>();
    }
    return structuration;
  }

  public void setStructuration(List<Level> structuration) {
    this.structuration = structuration;
  }

  public void addLevel(Level level) {
    getStructuration().add(level);
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
