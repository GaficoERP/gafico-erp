package sn.smart.eco.clients.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.clients.AbstractClientTest;
import sn.smart.eco.clients.config.ClientInfoConfigRestTest;
import sn.smart.eco.clients.model.ClientInfo;
import sn.smart.eco.clients.model.LegalStatus;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(classes = {ClientInfoConfigRestTest.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientInfoRestServiceTest extends AbstractClientTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void addClientInfoTest() throws Exception {
    ClientInfo client =
        new ClientInfo("Sonatel SA", "338280000", "sonatel-sa@sonatel.sn", LegalStatus.SA);
    mockMvc
        .perform(post("/rest/clients/add").contentType(MediaType.APPLICATION_JSON)
            .content(client.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("email").value("sonatel-sa@sonatel.sn"));
  }

  @Test
  @Ignore
  public void findClientInfoTest() throws Exception {
    // has result
    String clName = "Sonatel SA";
    mockMvc
        .perform(get("/rest/clients/find/{name}", clName).contentType(MediaType.APPLICATION_JSON)//
            .accept(MediaType.APPLICATION_JSON))//
        .andExpect(status().isOk())//
        // .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(jsonPath("name").value(clName));

    // Empty result
    mockMvc
        .perform(
            get("/rest/clients/find/{name}", "ClientName").contentType(MediaType.APPLICATION_JSON)//
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())//
        // .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(content().string(""));
  }
}
