package sn.smart.eco.common.jpa.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigRestTest;
import sn.smart.eco.common.jpa.model.GaficoComponent;

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

@ContextConfiguration(classes = {CommonConfigRestTest.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GaficoComponentRestServiceTest extends AbstractJpaCommonTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void addGaficoComponentTest() throws Exception {
    mockMvc
        .perform(post("/rest/common/component/add").contentType(MediaType.APPLICATION_JSON)
            .content(GaficoComponent.PAY.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("name").value("Pay"));


    mockMvc
        .perform(post("/rest/common/component/add").contentType(MediaType.APPLICATION_JSON)
            .content(GaficoComponent.DEFAULT.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("name").value("Default"));
  }

  @Test
  public void findByInDefaultPackTest() throws Exception {
    // has result
    mockMvc
        .perform(get("/rest/common/component/find/{inDefaultPack}", true)
            .contentType(MediaType.APPLICATION_JSON)//
            .accept(MediaType.APPLICATION_JSON))//
        .andDo(print())//
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(jsonPath("$[0].name").value("Default"));
  }
}
