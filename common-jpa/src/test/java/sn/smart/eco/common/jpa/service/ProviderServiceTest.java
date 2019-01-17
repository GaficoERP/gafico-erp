package sn.smart.eco.common.jpa.service;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.commonjpa.model.Provider;
import sn.smart.eco.commonjpa.service.ProviderService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

@ContextConfiguration(classes = {CommonConfigTest.class})
public class ProviderServiceTest extends AbstractJpaCommonTest {
  @Autowired
  private ProviderService service;

  @Test
  @Sql(scripts = "classpath:test-data/providers.sql")
  public void findByNameTest() {
    String name = "M2 Consulting 2";
    Provider provider = service.findProvider(name);
    Assert.assertNotNull(provider);
    Assert.assertEquals(name, provider.getName());

    provider = service.findProvider("Fake Provider");
    Assert.assertNull(provider);
  }
}
