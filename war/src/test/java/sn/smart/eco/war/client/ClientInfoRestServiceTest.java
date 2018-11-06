package sn.smart.eco.war.client;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.clients.model.ClientInfo;
import sn.smart.eco.clients.model.LegalStatus;
import sn.smart.eco.war.AbstractRestTest;
import sn.smart.eco.war.GaficoRestConfigTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
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

@ContextConfiguration(classes = {GaficoRestConfigTest.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientInfoRestServiceTest extends AbstractRestTest {
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
        new ClientInfo("Sonatel", "338280000", "sonatel-sa@sonatel.sn", LegalStatus.SA);
    mockMvc
        .perform(post("/rest/client/add").contentType(MediaType.APPLICATION_JSON)
            .content(client.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("email").value(client.getEmail()));
  }

  @Test
  public void findClientInfoTest() throws Exception {
    // has result
    String clName = "Sonatel";
    mockMvc
        .perform(get("/rest/client/find/{name}", clName).contentType(MediaType.APPLICATION_JSON)//
            .accept(MediaType.APPLICATION_JSON_UTF8))//
        .andDo(print())//
        .andExpect(status().isOk())//
        // .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(jsonPath("name").value(clName));

    // Empty result
    mockMvc
        .perform(
            get("/rest/client/find/{name}", "ClientName").contentType(MediaType.APPLICATION_JSON)//
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())//
        // .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(content().string(""));
  }
}
