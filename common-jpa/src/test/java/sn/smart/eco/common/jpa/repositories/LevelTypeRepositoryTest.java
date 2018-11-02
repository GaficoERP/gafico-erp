package sn.smart.eco.common.jpa.repositories;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.LevelType;
import sn.smart.eco.commonjpa.repositories.LevelTypeRepository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = {CommonConfigTest.class})
public class LevelTypeRepositoryTest extends AbstractJpaCommonTest {

  @Autowired
  private LevelTypeRepository repository;

  @Test
  public void saveLevelTypeTest() {
    LevelType ltype = new LevelType("LevelType0", 0, PlanType.ACCOUNTANCY);
    LevelType savedType = repository.save(ltype);
    Assert.assertNotNull(savedType);
    Assert.assertEquals(ltype.toString(), savedType.toString());
    System.out.println(savedType);
  }

  @Test
  public void findLevelTypeByPlan() {
    populateDb();

    Optional<List<LevelType>> lTypes = repository.findByPlan(PlanType.ACCOUNTANCY);
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
        new LevelType("LevelType3", 0, PlanType.ACCOUNTANCY), //
        new LevelType("LevelType1", 0, PlanType.BUDGET), //
        new LevelType("LevelType2", 0, PlanType.ANALYTICAL), //
        new LevelType("LevelType31", 31, PlanType.ACCOUNTANCY));

    repository.saveAll(ltypes);
  }
}
