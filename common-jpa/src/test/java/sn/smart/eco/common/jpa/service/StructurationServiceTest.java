package sn.smart.eco.common.jpa.service;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.commonjpa.model.Level;
import sn.smart.eco.commonjpa.model.Structuration;
import sn.smart.eco.commonjpa.service.StructurationService;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

@ContextConfiguration(classes = {CommonConfigTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class StructurationServiceTest extends AbstractJpaCommonTest {
  @Autowired
  private StructurationService structService;

  @Test
  public void a_addStructurationTest() {
    Structuration savedStruct = createStructuration();
    Assert.assertNotNull(savedStruct);
    Assert.assertEquals("Structuration", savedStruct.getName());
  }

  @Test
  public void b_findStructurationByNameTest() {
    createStructuration();

    Structuration struct = structService.findStructuration("Structuration");
    Assert.assertNotNull(struct);
  }

  @Test
  public void c_addLevelToStructurationTest() {
    createStructuration();

    Structuration struct = structService.findStructuration("Structuration");
    Structuration updatedStruct = structService.addLevel(struct, new Level("Chapitre", 2, null));
    Assert.assertTrue(updatedStruct.getLevels().size() == 1);
  }

  @Test
  public void d_addPreviousToLevelTest() {
    createStructuration();

    Structuration struct = structService.findStructuration("Structuration");
    Structuration updatedStruct = structService.addLevel(struct,
        new Level("Article", 1, struct.getLevels().iterator().next()));
    Assert.assertTrue(updatedStruct.getLevels().size() == 2);
  }

  private Structuration createStructuration() {
    Structuration struct = new Structuration("Structuration", null);
    return structService.addStructuration(struct);
  }
}
