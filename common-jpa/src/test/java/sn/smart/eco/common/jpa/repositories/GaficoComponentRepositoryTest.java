package sn.smart.eco.common.jpa.repositories;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.commonjpa.model.GaficoComponent;
import sn.smart.eco.commonjpa.repositories.GaficoComponentRepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = {CommonConfigTest.class})
public class GaficoComponentRepositoryTest extends AbstractJpaCommonTest {
  @Autowired
  private GaficoComponentRepository repository;

  @Test
  public void addComponentTest() {
    GaficoComponent savedComp = repository.save(GaficoComponent.ACCOUNTANCY);
    Assert.assertNotNull(savedComp);
    Assert.assertEquals(GaficoComponent.ACCOUNTANCY.toString(), savedComp.toString());
    System.out.println(savedComp.toString());
  }

  @Test
  public void findByInDefaultPackTest() {
    Optional<List<GaficoComponent>> components = repository.findByInDefaultPack(false);
    Assert.assertTrue(components.isPresent());
    Assert.assertFalse(components.get().isEmpty());
    Assert.assertTrue(components.get().size() >= 2);
    components.get().forEach(System.out::println);
  }

  @Before
  public void populateDb() {
    repository.saveAll(Arrays.asList(GaficoComponent.ACCOUNTANCY, GaficoComponent.BILLING,
        GaficoComponent.BUDGET, GaficoComponent.COMMITMENT));
  }

  @After
  public void cleanDb() {
    repository.deleteAll();
  }
}
