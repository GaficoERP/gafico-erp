package sn.smart.eco.common.jpa.repositories;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.commonjpa.model.ConfigParameter;
import sn.smart.eco.commonjpa.model.GaficoComponent;
import sn.smart.eco.commonjpa.repositories.ConfigParameterRepository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = {CommonConfigTest.class})
public class ConfigParameterRepositoryTest extends AbstractJpaCommonTest {
  @Autowired
  private ConfigParameterRepository repository;

  @Test
  public void saveConfigParameterTest() {
    ConfigParameter config = new ConfigParameter("ConfigParameter", "Config Value",
        GaficoComponent.PUBLIC_MARKET, true, String.class);
    ConfigParameter savedConfig = repository.save(config);
    Assert.assertNotNull(savedConfig);
    Assert.assertEquals(config.toString(), savedConfig.toString());
    System.out.println(savedConfig);
  }

  @Test
  public void findByComponentTest() {
    populateDb();

    Optional<List<ConfigParameter>> configs =
        repository.findByComponentId(GaficoComponent.ACCOUNTANCY.getId());
    Assert.assertTrue(configs.isPresent());
    Assert.assertFalse(configs.get().isEmpty());
    Assert.assertTrue(configs.get().size() >= 2);
    configs.get().forEach(System.out::println);
  }

  private void populateDb() {
    List<ConfigParameter> confParams = Arrays.asList(//
        new ConfigParameter("ConfigParameter1", new Integer(0).toString(),
            GaficoComponent.ACCOUNTANCY, true, Integer.class), //
        new ConfigParameter("ConfigParameter2", Boolean.FALSE.toString(),
            GaficoComponent.ACCOUNTANCY, true, Boolean.class), //
        new ConfigParameter("ConfigParameter3", "value", GaficoComponent.BILLING, true,
            String.class), //
        new ConfigParameter("ConfigParameter4", new Double(2.5).toString(),
            GaficoComponent.COMMITMENT, false, Double.class));

    repository.saveAll(confParams);
  }
}
