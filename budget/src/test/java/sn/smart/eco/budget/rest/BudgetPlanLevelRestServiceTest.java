package sn.smart.eco.budget.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.budget.AbstractBudgetTest;
import sn.smart.eco.budget.config.BudgetConfigRestTest;
import sn.smart.eco.budget.model.BudgetPlanLevel;
import sn.smart.eco.budget.utils.BudgetUtils;
import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.LevelType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(classes = {BudgetConfigRestTest.class})
@WebAppConfiguration
public class BudgetPlanLevelRestServiceTest extends AbstractBudgetTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @Autowired
  private MongoTemplate template;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void addBudgetPlanLevelTest() throws Exception {
    BudgetPlanLevel pLevel = new BudgetPlanLevel();
    pLevel.setLevel(new LevelType("Chapitre", 0, PlanType.ANALYTICAL));
    pLevel.setCode(11L);
    pLevel.setLabel("Reserve");

    mockMvc
        .perform(post("/rest/budget/add").contentType(MediaType.APPLICATION_JSON)
            .content(pLevel.toString()))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("label").value("Reserve"));
  }

  @Test
  public void findByLevelPlanTest() throws Exception {
    BudgetUtils.importJSON(template, "budget_plan_level",
        "src/test/resources/budget_embedded_data.json");
    // has result
    mockMvc
        .perform(get("/rest/budget/findByLevelPlan/{level}", PlanType.BUDGET)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(jsonPath("$[0].label").value("REPORT À NOUVEAU"));
  }

  @Test
  public void findBudgetPlanLevelTest() throws Exception {
    BudgetUtils.importJSON(template, "budget_plan_level",
        "src/test/resources/budget_embedded_data.json");

    String root =
        mockMvc.perform(get("/rest/budget/find/{code}", 12L).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())//
            .andDo(print())//
            .andExpect(jsonPath("label").value("REPORT À NOUVEAU"))//
            .andReturn().getResponse().getContentAsString();

    mockMvc
        .perform(get("/rest/budget/findByPrevious").content(root)
            .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())//
        .andDo(print());//
    // .andExpect(jsonPath("$[0].label").value("REPORT À NOUVEAU CRÉDITEUR"));
  }

  @After
  public void cleanUp() {
    template.getDb().drop();
  }
}
