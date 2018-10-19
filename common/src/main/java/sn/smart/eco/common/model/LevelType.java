package sn.smart.eco.common.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_leveltype")
public class LevelType {
  @Id
  private String name;
  @Column
  private int depth;
  @Column
  private PlanType plan;

  public LevelType() {}

  public LevelType(String name, int depth, PlanType plan) {
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

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
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
}
