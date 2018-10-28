package sn.smart.eco.clients.repositories;

import sn.smart.eco.clients.AbstractClientTest;
import sn.smart.eco.clients.config.ClientInfoConfigTest;
import sn.smart.eco.clients.model.ClientInfo;
import sn.smart.eco.clients.model.LegalStatus;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = {ClientInfoConfigTest.class})
public class ClientInfoRepositoryTest extends AbstractClientTest {
  @Autowired
  private ClientInfoRepository repository;

  @Test
  public void addClientInfoTest() {
    ClientInfo client =
        new ClientInfo("Sonatel SA", "338280000", "sonatel-sa@sonatel.sn", LegalStatus.SA);
    ClientInfo savedClient = repository.save(client);
    Assert.assertNotNull(savedClient);
    Assert.assertNotNull(savedClient.getId());
    Assert.assertEquals(client.getName(), savedClient.getName());
  }

  @Test
  public void findClientInfoByNameTest() {
    populateDb();

    String clName = "Etat Du Sénégal";
    Optional<ClientInfo> client = repository.findByName(clName);
    Assert.assertTrue(client.isPresent());
    Assert.assertNotNull(client.get());
    Assert.assertEquals(clName, client.get().getName());
    Assert.assertEquals(LegalStatus.PUBLIC, client.get().getLegalStatus());
  }

  private void populateDb() {
    List<ClientInfo> clients = Arrays.asList(//
        new ClientInfo("Etat Du Sénégal", "338200000", "etat-senegal@gouv.sn", LegalStatus.PUBLIC), //
        new ClientInfo("AtoS Sénégal", "338200001", "gdc-atos-sn@atos.net", LegalStatus.SA), //
        new ClientInfo("ONAS", "338200002", "onas@gouv.sn", LegalStatus.PARA_PUBLIC));

    repository.saveAll(clients);
  }
}
