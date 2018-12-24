package sn.smart.eco.war.common;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sn.smart.eco.common.utils.GaficoCommonUtils;
import sn.smart.eco.commonjpa.model.Level;
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

import java.util.Arrays;
import java.util.HashSet;

@ContextConfiguration(classes = {GaficoRestConfigTest.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LevelRestServiceTest extends AbstractRestTest {
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
    Level level0 = new Level("structuration", "level0", 1, 0);
    Level level1 = new Level("structuration", "level1", 1, 1);
    mockMvc
        .perform(post("/rest/common/level/addAll").contentType(MediaType.APPLICATION_JSON)
            .content(GaficoCommonUtils.toJsonString(new HashSet<>(Arrays.asList(level0, level1)))))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("$[0].name").value(level0.getName()));
  }

  @Test
  public void findByPreviousTest() throws Exception {
    Level level0 = new Level("structuration", "level0", 1, 0);
    // has result
    mockMvc
        .perform(
            get("/rest/common/level/findByPrevious/{position}/{structuration}", 0, "structuration")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())//
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(jsonPath("$[0].name").value(level0.getName()));

    // Empty result
    mockMvc
        .perform(
            get("/rest/common/level/findByPrevious/{position}/{structuration}", 1, "structuration")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())//
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
        .andExpect(content().string(""));
  }
}
