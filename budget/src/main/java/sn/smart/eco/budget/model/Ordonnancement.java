package sn.smart.eco.budget.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("budget_ordonnancement")
public class Ordonnancement {

  private Integer engagement;
  @Indexed(unique = true)
  private String reference;
  private Double amount;
  // private String budget;

  public Integer getEngagement() {
    return engagement;
  }

  public void setEngagement(Integer engagement) {
    this.engagement = engagement;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  // public String getBudget() {
  // return budget;
  // }
  //
  // public void setBudget(String budget) {
  // this.budget = budget;
  // }
}
