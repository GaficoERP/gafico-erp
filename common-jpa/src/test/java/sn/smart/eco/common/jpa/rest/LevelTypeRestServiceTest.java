package sn.smart.eco.common.jpa.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.common.jpa.AbstractJpaCommonTest;
import sn.smart.eco.common.jpa.config.CommonConfigRest;
import sn.smart.eco.common.jpa.model.LevelType;
import sn.smart.eco.common.model.PlanType;

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

@ContextConfiguration(classes = {CommonConfigRest.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LevelTypeRestServiceTest extends AbstractJpaCommonTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void addLevelTypeTest() throws Exception {
    LevelType ltype = new LevelType("LevelType0", 0, PlanType.ACCOUNTANCY);
    mockMvc
        .perform(post("/rest/common/level/add").contentType(MediaType.APPLICATION_JSON)
            .content(ltype.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("name").value("LevelType0"));
  }

  @Test
  public void findByPlanTypeTest() throws Exception {
    // has result
    mockMvc
        .perform(get("/rest/common/level/findByPlan/{plan}", PlanType.ACCOUNTANCY)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(jsonPath("$[0].name").value("LevelType0"));

    // Empty result
    mockMvc
        .perform(get("/rest/common/level/findByPlan/{plan}", PlanType.BUDGET)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(content().string("[]"));
  }
}
