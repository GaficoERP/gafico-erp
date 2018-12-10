package sn.smart.eco.common.mongo.services;

import sn.smart.eco.common.mongo.config.AbstractCommonMongoTest;
import sn.smart.eco.common.mongo.utils.CommonMongoUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class PlanLineServiceTest extends AbstractCommonMongoTest {
  @Autowired
  private PlanLineService service;
  @Autowired
  private MongoTemplate template;

  @Test
  public void getNewCodeTest() {
    CommonMongoUtils.importJSON(template, "plan_line",
        "src/test/resources/common_embedded_data.json");


    String code = service.getNewCode("Article", 1, "Plan Budgetaire 2018", null);
    Assert.assertTrue(StringUtils.isNotEmpty(code));
    Assert.assertEquals("3", code);

    code = service.getNewCode("Article2", 1, "Plan Budgetaire 2018", null);
    Assert.assertTrue(StringUtils.isNotEmpty(code));
    Assert.assertEquals("1", code);
  }
}
