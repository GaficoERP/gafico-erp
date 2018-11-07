package sn.smart.eco.commonjpa.model;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.common.utils.GaficoCommonUtils;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "common_structuration")
public class Structuration {
  @Id
  @Column(name = "struct_name")
  private String name;
  @OneToMany
  private Set<LevelType> levels;
  private PlanType type;

  public Structuration(String name, Set<LevelType> levels, PlanType type) {
    super();
    this.name = name;
    this.levels = levels;
    this.type = type;
  }

  public Structuration() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<LevelType> getLevels() {
    return levels;
  }

  public void setLevels(Set<LevelType> levels) {
    this.levels = levels;
  }

  public PlanType getType() {
    return type;
  }

  public void setType(PlanType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
