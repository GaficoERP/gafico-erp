package sn.smart.eco.common.jpa.utils;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.common.jpa.model.ConfigParameter;
import sn.smart.eco.common.jpa.model.GaficoComponent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = {CommonConfigTest.class})
public class ConfigParametersTest extends AbstractJpaCommonTest {

  @Autowired
  private ConfigParameters cParams;

  @Test
  public void getParameterTest() {
    String name = "ConfigParameter3";
    ConfigParameter param = cParams.getParameter(name);
    Assert.assertNotNull(param);
    Assert.assertEquals(name, param.getName());
    Assert.assertEquals(Boolean.class, param.getValueClass());
    System.out.println(param);
  }

  @Test
  public void isValueTrueSuccessTest() {
    String name = "ConfigParameter3";
    Assert.assertTrue(cParams.isValueTrue(name));
  }

  @Test
  public void isValueTrueFailed1Test() {
    String name = "ConfigParameter1";
    Assert.assertFalse(cParams.isValueTrue(name));
  }

  @Test
  public void isValueTrueFailed2Test() {
    String name = "ConfigParameter2";
    Assert.assertFalse(cParams.isValueTrue(name));
  }

  @Before
  public void populateDb() {
    List<ConfigParameter> confParams = Arrays.asList(//
        new ConfigParameter("ConfigParameter1", new Integer(0).toString(),
            GaficoComponent.ACCOUNTANCY, true, Integer.class), //
        new ConfigParameter("ConfigParameter2", Boolean.FALSE.toString(),
            GaficoComponent.ACCOUNTANCY, true, Boolean.class), //
        new ConfigParameter("ConfigParameter3", "value", GaficoComponent.BILLING, true,
            String.class), //
        new ConfigParameter("ConfigParameter4", new Double(2.5).toString(),
            GaficoComponent.COMMITMENT, false, Double.class));

    cParams.saveAll(confParams);
  }

}
