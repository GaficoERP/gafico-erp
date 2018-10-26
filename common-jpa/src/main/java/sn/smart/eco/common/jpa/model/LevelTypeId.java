package sn.smart.eco.common.jpa.model;

import sn.smart.eco.common.model.PlanType;

import java.io.Serializable;

public class LevelTypeId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer depth;
	private PlanType plan;

	public LevelTypeId() {
	}

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
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof LevelTypeId)) {
			return false;
		}

		LevelTypeId ltype = (LevelTypeId) obj;
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
