package sn.smart.eco.common.mongo.model;

import sn.smart.eco.common.model.GaficoNature;
import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("plan_line")
public class PlanLine {
  @Id
  private String id;
  private String label;
  @Indexed(unique = true)
  private String code;
  private String levelName;
  private GaficoNature nature;
  // @DBRef(lazy = false)
  // private PlanLine previous;
  private String plan;

  public PlanLine() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLevelName() {
    return levelName;
  }

  public void setLevelName(String levelName) {
    this.levelName = levelName;
  }

  public GaficoNature getNature() {
    return nature;
  }

  public void setNature(GaficoNature nature) {
    this.nature = nature;
  }

  // public PlanLine getPrevious() {
  // return previous;
  // }
  //
  // public void setPrevious(PlanLine previous) {
  // this.previous = previous;
  // }

  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
