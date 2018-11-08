package sn.smart.eco.war.client;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.clients.model.GaficoLicense;
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
import java.util.HashSet;
import java.util.UUID;

@ContextConfiguration(classes = {GaficoRestConfigTest.class})
@WebAppConfiguration
public class GaficoLicenseRestServiceTest extends AbstractRestTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void addGaficoLicenseTest() throws Exception {
    GaficoLicense license = new GaficoLicense(UUID.randomUUID().toString(), new Date(), null, 3L,
        new HashSet<>(), null);
    mockMvc
        .perform(post("/rest/client/license/add").contentType(MediaType.APPLICATION_JSON)
            .content(license.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("endDate").value(license.getEndDate()));
  }
}
