package sn.smart.eco.commonjpa.model;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "common_plan")
public class Plan {
  @Transient
  public static final String PLAN_LINEID_SEPARATOR = ",";
  @Id
  private String name;
  @OneToOne
  private Structuration structuration;
  private String planLineIds;

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

  public String getPlanLineIds() {
    return planLineIds;
  }

  public void addPlanLineId(String planLineId) {
    if (StringUtils.isEmpty(planLineIds)) {
      this.planLineIds = planLineId;
    }
    this.planLineIds += PLAN_LINEID_SEPARATOR + planLineId;
  }
}
