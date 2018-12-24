package sn.smart.eco.budget.repositories;

import sn.smart.eco.budget.AbstractBudgetTest;
import sn.smart.eco.budget.config.BudgetConfigTest;
import sn.smart.eco.budget.model.Budget;
import sn.smart.eco.budget.repositories.BudgetRepository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {BudgetConfigTest.class})
public class BudgetRepositoryTest extends AbstractBudgetTest {
  @Autowired
  private BudgetRepository repository;

  @Test
  public void addBudgetTest() {
    Budget budget = new Budget();
    budget.setName("Budget 2018 Ministere des Finances");
    Budget savedBudget = repository.save(budget);
    Assert.assertNotNull(savedBudget);
    Assert.assertNotNull(savedBudget.getId());
    Assert.assertEquals(budget.getName(), savedBudget.getName());
  }
}
