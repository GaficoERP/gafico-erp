package sn.smart.eco.commonjpa.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_level")
public class Level {
  // @EmbeddedId
  // private Structuration identifier;
  private String structuration;
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "lv_name")
  private String name;
  private Integer codeLength;
  private Integer position;

  // @ManyToOne
  // private Level previous;
  // @OneToMany(mappedBy = "previous")
  // private List<Level> children;

  public Level() {}

  // public Level(String name, Integer codeLength, Level previous) {
  // this.name = name;
  // this.codeLength = codeLength;
  // this.previous = previous;
  // }


  public Level(String structuration, String name, Integer codeLength, Integer position) {
    this.structuration = structuration;
    this.name = name;
    this.codeLength = codeLength;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCodeLength() {
    return codeLength;
  }

  public void setCodeLength(Integer codeLength) {
    this.codeLength = codeLength;
  }

  // public Level getPrevious() {
  // return previous;
  // }
  //
  // public void setPrevious(Level previous) {
  // this.previous = previous;
  // }
  //
  // public Long getId() {
  // return id;
  // }
  //
  // public void setId(Long id) {
  // this.id = id;
  // }
  //
  // public List<Level> getChildren() {
  // return children;
  // }
  //
  // public void setChildren(List<Level> children) {
  // this.children = children;
  // }

  // public Structuration getIdentifier() {
  // return identifier;
  // }
  //
  // public void setIdentifier(Structuration identifier) {
  // this.identifier = identifier;
  // }

  public String getStructuration() {
    return structuration;
  }

  public void setStructuration(String structuration) {
    this.structuration = structuration;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }

}
