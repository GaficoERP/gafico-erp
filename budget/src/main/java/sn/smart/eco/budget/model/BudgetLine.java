package sn.smart.eco.budget.model;

import sn.smart.eco.common.model.GaficoNature;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("budget_line")
public class BudgetLine {
  @Indexed(unique = true)
  private String code;
  private String label;
  private GaficoNature nature;
  private String budgetName;
  private Double amount;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public GaficoNature getNature() {
    return nature;
  }

  public void setNature(GaficoNature nature) {
    this.nature = nature;
  }

  public String getBudgetName() {
    return budgetName;
  }

  public void setBudgetName(String budgetName) {
    this.budgetName = budgetName;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

}
