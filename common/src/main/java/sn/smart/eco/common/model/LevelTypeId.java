package sn.smart.eco.common.model;


import java.io.Serializable;

public class LevelTypeId implements Serializable {
  private static final long serialVersionUID = 1L;

  private String name;
  private Integer depth;
  private PlanType plan;

  public LevelTypeId() {}

  public LevelTypeId(String name, Integer depth, PlanType plan) {
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
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	LevelTypeId other = (LevelTypeId) obj;
	if (depth == null) {
		if (other.depth != null)
			return false;
	} else if (!depth.equals(other.depth))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (plan != other.plan)
		return false;
	return true;
}

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((depth == null) ? 0 : depth.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((plan == null) ? 0 : plan.hashCode());
	return result;
}
}
