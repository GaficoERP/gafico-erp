package sn.smart.eco.commonjpa.model;

import java.io.Serializable;

// @Entity
// @Table(name = "common_structuration")
// @Embeddable
public class Structuration implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Id
  // @Column(name = "struct_name")
  private String structuration;
  // @Id
  private Long id;
  // @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  // private Set<Level> levels;
  // private PlanType type;

  // public Structuration(String name, Set<Level> levels) {
  // super();
  // this.name = name;
  // this.levels = levels;
  // }

  // public Structuration() {}

  // public String getName() {
  // return name;
  // }
  //
  // public void setName(String name) {
  // this.name = name;
  // }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStructuration() {
    return structuration;
  }

  public void setStructuration(String structuration) {
    this.structuration = structuration;
  }

  // public Set<Level> getLevels() {
  // if (CollectionUtils.isEmpty(levels)) {
  // levels = new HashSet<>();
  // }
  // return levels;
  // }
  //
  // public void setLevels(Set<Level> levels) {
  // this.levels = levels;
  // }
  //
  // public void addLevel(Level level) {
  // getLevels().add(level);
  // }

  // @Override
  // public String toString() {
  // return GaficoCommonUtils.toJsonString(this);
  // }
}
