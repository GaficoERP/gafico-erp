package sn.smart.eco.clients.repositories;

import sn.smart.eco.clients.AbstractClientTest;
import sn.smart.eco.clients.config.ClientInfoConfigTest;
import sn.smart.eco.clients.model.GaficoLicense;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

import javax.transaction.Transactional;

@ContextConfiguration(classes = {ClientInfoConfigTest.class})
public class GaficoLicenseRepositoryTest extends AbstractClientTest {
  @Autowired
  private GaficoLicenseRepository repository;

  @Test
  @Transactional
  public void addGaficoLicenseTest() {
    GaficoLicense license = new GaficoLicense(UUID.randomUUID().toString(), new Date(), null, 3L,
        new HashSet<>(), null);
    GaficoLicense savedLicense = repository.save(license);
    Assert.assertNotNull(savedLicense);
    Assert.assertNotNull(savedLicense.getLicenseId());
    Assert.assertNotNull(savedLicense.getComponents());
    Assert.assertEquals(license.getComponents().size(), savedLicense.getComponents().size());
    System.out.println(savedLicense);
  }
}
