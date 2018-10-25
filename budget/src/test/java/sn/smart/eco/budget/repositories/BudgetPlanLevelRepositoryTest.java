package sn.smart.eco.budget.repositories;

import sn.smart.eco.budget.AbstractBudgetTest;
import sn.smart.eco.budget.config.BudgetConfigTest;
import sn.smart.eco.budget.model.BudgetPlanLevel;
import sn.smart.eco.common.model.LevelType;
import sn.smart.eco.common.model.PlanType;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ContextConfiguration(classes = {BudgetConfigTest.class})
@FixMethodOrder(MethodSorters.DEFAULT)
public class BudgetPlanLevelRepositoryTest extends AbstractBudgetTest {

  @Autowired
  private BudgetPlanLevelRepository repository;

  @Test
  public void saveBudgetPlanLevelTest() {
    BudgetPlanLevel pLevel = new BudgetPlanLevel();
    pLevel.setLevel(new LevelType("Chapitre", 0, PlanType.ANALYTICAL));
    pLevel.setCode("11");
    pLevel.setLabel("Reserve");

    BudgetPlanLevel savedPLevel = repository.insert(pLevel);
    Assert.assertNotNull(savedPLevel);
    Assert.assertEquals(pLevel.getCode(), savedPLevel.getCode());
    Assert.assertEquals(pLevel.getLevel(), savedPLevel.getLevel());
    System.out.println(savedPLevel);
  }

  @Test
  public void saveBudgetPlanLevelWithPreviousTest() {
    BudgetPlanLevel root = new BudgetPlanLevel();
    root.setLevel(new LevelType("Chapitre", 0, PlanType.BUDGET));
    root.setCode("12");
    root.setLabel("REPORT À NOUVEAU");
    BudgetPlanLevel savedRoot = repository.insert(root);
    Assert.assertNotNull(savedRoot);
    Assert.assertEquals(root.getCode(), savedRoot.getCode());
    Assert.assertEquals(root.getLevel(), savedRoot.getLevel());

    BudgetPlanLevel pLevel = new BudgetPlanLevel(UUID.randomUUID().toString(), "121",
        "REPORT À NOUVEAU CRÉDITEUR", new LevelType("Article", 1, PlanType.BUDGET), savedRoot);

    BudgetPlanLevel savedPLevel = repository.insert(pLevel);
    Assert.assertNotNull(savedPLevel);
    Assert.assertEquals(pLevel.getCode(), savedPLevel.getCode());
    Assert.assertEquals(pLevel.getLevel(), savedPLevel.getLevel());
    Assert.assertEquals(savedRoot, savedPLevel.getPrevious());
  }

  @Test
  public void findByLevelPlanTest() {
    Optional<List<BudgetPlanLevel>> bpLevels = repository.findByLevelPlan(PlanType.BUDGET);
    Assert.assertTrue(bpLevels.isPresent());
    Assert.assertTrue(!bpLevels.get().isEmpty());
    Assert.assertTrue(bpLevels.get().size() == 2);
    bpLevels.get().forEach(System.out::println);
  }
}
