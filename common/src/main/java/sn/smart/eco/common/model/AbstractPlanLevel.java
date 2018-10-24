package sn.smart.eco.common.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.springframework.data.annotation.Id;

public abstract class AbstractPlanLevel {
  @Id
  private String id;
  private String code;
  private String label;
  private LevelType level;

  public AbstractPlanLevel() {}

  public AbstractPlanLevel(String id, String code, String label, LevelType level) {
    this.id = id;
    this.code = code;
    this.label = label;
    this.level = level;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public LevelType getLevel() {
    return level;
  }

  public void setLevel(LevelType level) {
    this.level = level;
  }

  public abstract AbstractPlanLevel getPrevious();

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
