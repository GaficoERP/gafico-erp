package sn.smart.eco.commonjpa.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "common_level")
public class Level {
  @Id
  @Column(name = "lv_name")
  private String name;
  private Integer codeLength;
  
  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="parent")
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

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }

}
