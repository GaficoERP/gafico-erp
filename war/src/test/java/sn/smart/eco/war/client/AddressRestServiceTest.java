package sn.smart.eco.war.client;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.clients.model.Address;
import sn.smart.eco.war.AbstractRestTest;
import sn.smart.eco.war.GaficoRestConfigTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@ContextConfiguration(classes = {GaficoRestConfigTest.class})
@WebAppConfiguration
public class AddressRestServiceTest extends AbstractRestTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void addAddressTest() throws Exception {
    Address add =
        new Address("1 Place de l'Indépendance", "Dakar", "Sénégal", null, true, new Date(), null);
    mockMvc
        .perform(post("/rest/client/address/add").contentType(MediaType.APPLICATION_JSON)
            .content(add.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("city").value(add.getCity()));
  }
}
