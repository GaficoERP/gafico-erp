package sn.smart.eco.budget.model;

import sn.smart.eco.commonjpa.model.Exercice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "budget")
public class Budget implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private Long id;
  @Column(nullable = false, unique = true)
  private String name;
  @OneToOne
  private Exercice exercice;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Exercice getExercice() {
    return exercice;
  }

  public void setExercice(Exercice exercice) {
    this.exercice = exercice;
  }
}
