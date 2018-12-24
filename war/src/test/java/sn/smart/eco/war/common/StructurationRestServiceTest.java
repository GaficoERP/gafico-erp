package sn.smart.eco.war.common;

// @ContextConfiguration(classes = { GaficoRestConfigTest.class })
// @WebAppConfiguration
// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StructurationRestServiceTest /* extends AbstractRestTest */ {
  // private MockMvc mockMvc;
  //
  // @Autowired
  // private WebApplicationContext wac;
  //
  // @Before
  // public void setUp() {
  // MockitoAnnotations.initMocks(this);
  // mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  // }
  //
  // @Test
  // public void addStructurationTest() throws Exception {
  // Structuration struct = new Structuration("Structuration", null);
  // mockMvc.perform(
  // post("/rest/common/struct/add").contentType(MediaType.APPLICATION_JSON).content(struct.toString()))
  // .andExpect(status().isOk())//
  // .andExpect(jsonPath("name").value("Structuration"));
  // }
  //
  // @Test
  // public void findStructurationTest() throws Exception {
  // // has result
  // String name = "Structuration";
  // mockMvc.perform(get("/rest/common/struct/find/{name}",
  // name).accept(MediaType.APPLICATION_JSON))
  // .andExpect(status().isOk())//
  // .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
  // .andExpect(jsonPath("name").value(name));
  //
  // // Empty result
  // mockMvc.perform(get("/rest/common/struct/find/{name}",
  // "Name").accept(MediaType.APPLICATION_JSON))
  // .andExpect(status().isOk())//
  // .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))//
  // .andExpect(content().string(""));
  // }
}
