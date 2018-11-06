package sn.smart.eco.clients.repositories;

import sn.smart.eco.clients.AbstractClientTest;
import sn.smart.eco.clients.config.ClientInfoConfigTest;
import sn.smart.eco.clients.model.Address;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@ContextConfiguration(classes = {ClientInfoConfigTest.class})
public class AddressRepositoryTest extends AbstractClientTest {
  @Autowired
  private AddressRepository repository;

  @Test
  public void addAddressTest() {
    Address add =
        new Address("1 Place de l'Indépendance", "Dakar", "Sénégal", null, true, new Date(), null);

    Address savedAdd = repository.save(add);
    Assert.assertNotNull(savedAdd);
    Assert.assertNotNull(savedAdd.getId());
  }
}
