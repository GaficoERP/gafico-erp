package sn.smart.eco.common.mongo.repositories;

import sn.smart.eco.common.model.GaficoNature;
import sn.smart.eco.common.mongo.config.AbstractCommonMongoTest;
import sn.smart.eco.common.mongo.model.PlanLine;
import sn.smart.eco.common.mongo.utils.CommonMongoUtils;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Optional;

public class PlanLineRepositoryTest extends AbstractCommonMongoTest {

  @Autowired
  private PlanLineRepository repository;
  @Autowired
  private MongoTemplate template;

  @Test
  public void addPlanLineTest() {
    repository.deleteAll();

    PlanLine pl = new PlanLine();
    pl.setCode(1);
    pl.setLabel("Ligne de Plan 1");
    pl.setLevelName("Article");
    pl.setPlan("Plan Budgetaire 2018");
    pl.setNature(GaficoNature.RECETTE_INVESTISSEMENT);

    PlanLine savedPl = repository.save(pl);
    Assert.assertNotNull(savedPl);
    Assert.assertEquals(pl.toString(), savedPl.toString());
    System.out.println(savedPl);
  }

  @Test
  public void findByLevelNameTest() {
    Optional<List<PlanLine>> plines = repository.findByLevelName("Article");
    Assert.assertTrue(plines.isPresent());
    Assert.assertTrue(CollectionUtils.isNotEmpty(plines.get()));
    Assert.assertTrue(plines.get().size() == 2);

    plines.get().forEach(pl -> System.out.println(pl));
  }

  @Test
  public void findByCodeAndPlanTest() {
    String plan = "Plan Budgetaire 2018";
    Optional<PlanLine> pl = repository.findByCodeAndPlan(1, plan);
    Assert.assertTrue(pl.isPresent());
    Assert.assertEquals(plan, pl.get().getPlan());
  }

  @Before
  public void populateDocument() {
    repository.deleteAll();

    CommonMongoUtils.importJSON(template, "plan_line",
        "src/test/resources/common_embedded_data.json");
  }
}
