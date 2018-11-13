package sn.smart.eco.commonjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "common_level")
public class Level {
  @Id
  @Column(name = "lv_name")
  private String name;
  private Integer codeLength;
  @JoinColumn(referencedColumnName = "name")
  private Level previous;

  public Level() {}

  public Level(String name, Integer codeLength, Level previous) {
    this.name = name;
    this.codeLength = codeLength;
    this.previous = previous;
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

  public Level getPrevious() {
    return previous;
  }

  public void setPrevious(Level previous) {
    this.previous = previous;
  }

}