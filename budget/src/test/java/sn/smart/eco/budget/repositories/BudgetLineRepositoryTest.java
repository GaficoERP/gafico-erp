package sn.smart.eco.budget.repositories;

import sn.smart.eco.budget.AbstractBudgetTest;
import sn.smart.eco.budget.config.BudgetConfigTest;
import sn.smart.eco.budget.model.BudgetLine;
import sn.smart.eco.budget.mongo.repositories.BudgetLineRepository;
import sn.smart.eco.common.model.GaficoNature;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {BudgetConfigTest.class})
public class BudgetLineRepositoryTest extends AbstractBudgetTest {
  @Autowired
  private BudgetLineRepository repository;

  @Test
  public void addBudgetLineTest() {
    BudgetLine line = new BudgetLine();
    line.setAmount(12000d);
    line.setBudgetName("Budget 2018 Ministere des Finances");
    line.setCode("12001");
    line.setLabel("Une Nouvelle ligne budgetaire");
    line.setNature(GaficoNature.DEPENSE_FONCTIONNEMENT);

    BudgetLine savedLine = repository.save(line);
    Assert.assertNotNull(savedLine);
    Assert.assertEquals(line.getBudgetName(), savedLine.getBudgetName());
  }
}
