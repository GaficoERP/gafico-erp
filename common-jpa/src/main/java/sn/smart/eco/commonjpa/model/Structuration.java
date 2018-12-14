package sn.smart.eco.commonjpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections4.CollectionUtils;

import sn.smart.eco.common.utils.GaficoCommonUtils;

@Entity
@Table(name = "common_structuration")
public class Structuration {
	@Id
	@Column(name = "struct_name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Level> levels;
	// private PlanType type;

	public Structuration(String name, Set<Level> levels) {
		super();
		this.name = name;
		this.levels = levels;
	}

	public Structuration() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Level> getLevels() {
		if (CollectionUtils.isEmpty(levels)) {
			levels = new HashSet<>();
		}
		return levels;
	}

	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}

	public void addLevel(Level level) {
		getLevels().add(level);
	}

	@Override
	public String toString() {
		return GaficoCommonUtils.toJsonString(this);
	}
}
