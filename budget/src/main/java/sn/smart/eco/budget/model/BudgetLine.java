package sn.smart.eco.budget.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("budget_line")
public class BudgetLine {

  private Date startDate;
  private Date endDate;
  private String account;

}
