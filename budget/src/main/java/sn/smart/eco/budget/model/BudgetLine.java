package sn.smart.eco.budget.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document("budget_line")
public class BudgetLine {

  private Date startDate;
  private Date endDate;
  private String account;
  private String label;
  private double amount;
  private Map<String, Double> distributions;

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Map<String, Double> getDistributions() {
    return distributions;
  }

  public void setDistributions(Map<String, Double> distributions) {
    this.distributions = distributions;
  }
}
