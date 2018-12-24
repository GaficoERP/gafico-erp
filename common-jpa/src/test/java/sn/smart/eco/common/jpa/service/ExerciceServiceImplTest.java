package sn.smart.eco.common.jpa.service;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.commonjpa.model.Exercice;
import sn.smart.eco.commonjpa.service.impl.ExerciceServiceImpl;

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
public class ExerciceServiceImplTest extends AbstractJpaCommonTest {
  @Autowired
  private ExerciceServiceImpl service;

  @Test
  public void addExerciceTest() {
    Exercice exo = new Exercice();
    exo.setStart("2018-01-01");
    exo.setEnd("2018-12-31");
    exo.setYear(2018);

    Exercice savedExo = service.addExercice(exo);
    Assert.assertEquals(exo.toString(), savedExo.toString());
  }
}
