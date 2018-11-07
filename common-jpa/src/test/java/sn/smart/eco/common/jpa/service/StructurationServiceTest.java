package sn.smart.eco.common.jpa.service;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.LevelType;
import sn.smart.eco.commonjpa.model.Structuration;
import sn.smart.eco.commonjpa.service.StructurationService;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.HashSet;

import javax.transaction.Transactional;

@ContextConfiguration(classes = {CommonConfigTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class StructurationServiceTest extends AbstractJpaCommonTest {
  @Autowired
  private StructurationService structService;

  @Test
  public void addStructurationTest() {
    Structuration savedStruct = createStructuration();
    Assert.assertNotNull(savedStruct);
    Assert.assertTrue(savedStruct.getLevels().size() == 2);
    Assert.assertEquals(PlanType.ACCOUNTANCY, savedStruct.getType());
  }

  @Test
  public void findStructurationByNameTest() {
    createStructuration();

    Structuration struct = structService.findStructurationByName("Structuration");
    Assert.assertNotNull(struct);
    Assert.assertTrue(struct.getLevels().size() == 2);
    Assert.assertEquals(PlanType.ACCOUNTANCY, struct.getType());
  }

  @Test
  public void findStructurationByTypeTest() {
    createStructuration();

    Structuration struct = structService.findStructurationByType(PlanType.ACCOUNTANCY);
    Assert.assertNotNull(struct);
    Assert.assertTrue(struct.getLevels().size() == 2);
    Assert.assertEquals(PlanType.ACCOUNTANCY, struct.getType());
  }

  private Structuration createStructuration() {
    Structuration struct = new Structuration("Structuration",
        new HashSet<>(Arrays.asList(new LevelType("Level0", 0, PlanType.ACCOUNTANCY),
            new LevelType("Level1", 1, PlanType.ACCOUNTANCY))),
        PlanType.ACCOUNTANCY);
    return structService.addStructuration(struct);
  }

}
