package sn.smart.eco.war.common;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.commonjpa.model.ConfigParameter;
import sn.smart.eco.commonjpa.model.GaficoComponent;
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
public class ConfigParameterRestServiceTest extends AbstractRestTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void addConfigParameterTest() throws Exception {
    ConfigParameter conf = new ConfigParameter("ConfigParameter1", new Integer(0).toString(),
        GaficoComponent.ACCOUNTANCY, Boolean.TRUE, Integer.class);
    mockMvc
        .perform(post("/rest/common/config/add").contentType(MediaType.APPLICATION_JSON)
            .content(conf.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("name").value("ConfigParameter1"));
  }

  @Test
  public void findConfigParameterTest() throws Exception {
    // has result
    mockMvc
        .perform(get("/rest/common/config/find/{confName}", "ConfigParameter1")
            .contentType(MediaType.APPLICATION_JSON)//
            .accept(MediaType.APPLICATION_JSON))//
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(jsonPath("name").value("ConfigParameter1"));

    // Empty result
    mockMvc
        .perform(get("/rest/common/config/find/{confName}", "ConfigParameter0")
            .contentType(MediaType.APPLICATION_JSON)//
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())//
        // .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(content().string(""));
  }
}
