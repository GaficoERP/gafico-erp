package sn.smart.eco.commonjpa.model;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.common.utils.GaficoCommonUtils;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "common_level_type")
@IdClass(value = LevelTypeId.class)
public class LevelType implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private String name;
  @Id
  private Integer depth;
  @Id
  private PlanType plan;

  public LevelType() {}

  public LevelType(String name, Integer depth, PlanType plan) {
    super();
    this.name = name;
    this.depth = depth;
    this.plan = plan;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDepth() {
    return depth;
  }

  public void setDepth(Integer depth) {
    this.depth = depth;
  }

  public PlanType getPlan() {
    return plan;
  }

  public void setPlan(PlanType plan) {
    this.plan = plan;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (!obj.getClass().equals(getClass())) {
      return false;
    }

    LevelType ltype = (LevelType) obj;
    if (this == ltype) {
      return true;
    }

    if (hashCode() == ltype.hashCode()) {
      return true;
    }

    if (name.equals(ltype.name) && depth.equals(ltype.depth) && plan.equals(ltype.plan)) {
      return true;
    }

    return false;
  }

  @Override
  public int hashCode() {
    return name.hashCode() + depth + plan.hashCode();
  }
}
