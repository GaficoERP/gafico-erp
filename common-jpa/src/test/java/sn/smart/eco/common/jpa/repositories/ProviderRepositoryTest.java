package sn.smart.eco.common.jpa.repositories;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigTest;
import sn.smart.eco.commonjpa.model.Provider;
import sn.smart.eco.commonjpa.repositories.ProviderRepository;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@ContextConfiguration(classes = {CommonConfigTest.class})
public class ProviderRepositoryTest extends AbstractJpaCommonTest {
  @Autowired
  private ProviderRepository repository;

  @Test
  public void saveProviderTest() {
    Provider provider = new Provider();
    provider.setAccountLabel("Libellé du compte");
    provider.setAccountNumber("Numéro du Compte");
    provider.setAddress("Adresse postale du Fournisseur");
    provider.setBankAccount("Numéro de Compte Bancaire");
    provider.setEmail("Adresse mail du Fournisseur");
    provider.setFaxNumber("facultatif");
    provider.setName("Nom du Fournisseur");
    provider.setNinea("Ninea du Fournisseur");
    provider.setPhoneNumber("Numéro de téléphone du Fournisseur");
    provider.setPhoneNumber2("facultatif");

    Provider savedProvider = repository.save(provider);
    Assert.assertNotNull(savedProvider);
    Assert.assertEquals(provider.getName(), savedProvider.getName());
    // System.out.println(savedProvider.toString());

    cleanUp();
  }

  @Test
  @Sql(scripts = "classpath:test-data/providers.sql")
  public void findAllTest() {
    List<Provider> providers = repository.findAll();
    Assert.assertFalse(CollectionUtils.isEmpty(providers));
    Assert.assertTrue(providers.size() == 3);
  }

  // @Before
  public void cleanUp() {
    repository.deleteAll();
  }
}
