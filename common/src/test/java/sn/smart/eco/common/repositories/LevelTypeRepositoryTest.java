package sn.smart.eco.common.repositories;

import sn.smart.eco.common.AbstractCommonTest;
import sn.smart.eco.common.config.CommonConfigTest;
import sn.smart.eco.common.model.LevelType;
import sn.smart.eco.common.model.PlanType;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = {CommonConfigTest.class})
public class LevelTypeRepositoryTest extends AbstractCommonTest {

  @Autowired
  private LevelTypeRepository repository;

  @Test
  public void saveLevelTypeTest() {
    LevelType ltype = new LevelType("LevelType0", 0, PlanType.ACCOUNTING);
    LevelType savedType = repository.save(ltype);
    Assert.assertNotNull(savedType);
    Assert.assertEquals(ltype.toString(), savedType.toString());
    System.out.println(savedType);
  }

  @Test
  public void findLevelTypeByPlan() {
    populateDb();

    Optional<List<LevelType>> lTypes = repository.findByPlan(PlanType.ACCOUNTING);
    Assert.assertTrue(lTypes.isPresent());
    Assert.assertFalse(lTypes.get().isEmpty());
    Assert.assertTrue(lTypes.get().size() >= 2);
    lTypes.get().forEach(System.out::println);
  }

  // @Test
  // public void duplicateLevelTypeTest() {
  // repository.save(new LevelType("LevelType", 0, PlanType.ACCOUNTING));
  // repository.save(new LevelType("LevelType", 0, PlanType.ACCOUNTING));
  // }

  private void populateDb() {
    List<LevelType> ltypes = Arrays.asList(//
        new LevelType("LevelType3", 0, PlanType.ACCOUNTING), //
        new LevelType("LevelType1", 0, PlanType.BUDGET), //
        new LevelType("LevelType2", 0, PlanType.ANALYTICAL), //
        new LevelType("LevelType31", 31, PlanType.ACCOUNTING));

    repository.saveAll(ltypes);
  }
}
