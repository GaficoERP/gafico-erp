package sn.smart.eco.war.common;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import sn.smart.eco.commonjpa.model.Structuration;
import sn.smart.eco.war.AbstractRestTest;
import sn.smart.eco.war.GaficoRestConfigTest;

@ContextConfiguration(classes = { GaficoRestConfigTest.class })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StructurationRestServiceTest extends AbstractRestTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void addStructurationTest() throws Exception {
		Structuration struct = new Structuration("Structuration", null);
		mockMvc.perform(
				post("/rest/common/struct/add").contentType(MediaType.APPLICATION_JSON).content(struct.toString()))
				.andExpect(status().isOk())//
				.andExpect(jsonPath("name").value("Structuration"));
	}

	@Test
	public void findStructurationTest() throws Exception {
		// has result
		String name = "Structuration";
		mockMvc.perform(get("/rest/common/struct/find/{name}", name).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())//
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
				.andExpect(jsonPath("name").value(name));

		// Empty result
		mockMvc.perform(get("/rest/common/struct/find/{name}", "Name").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())//
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
				.andExpect(content().string(""));
	}
}
