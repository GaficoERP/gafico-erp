package sn.smart.eco.common.repositories;

import sn.smart.eco.common.AbstractCommonTest;
import sn.smart.eco.common.model.LevelType;
import sn.smart.eco.common.model.PlanType;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LevelTypeRepositoryTest extends AbstractCommonTest {

  @Autowired
  private LevelTypeRepository repository;

  @Test
  public void saveLevelTypeTest() {
    LevelType ltype = new LevelType("LevelType1", 0, PlanType.ACCOUNTING);
    LevelType savedType = repository.save(ltype);
    Assert.assertNotNull(savedType);
    Assert.assertEquals(ltype.toString(), savedType.toString());
    System.out.println(savedType);
  }
}
