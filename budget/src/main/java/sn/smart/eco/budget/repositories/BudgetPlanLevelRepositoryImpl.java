package sn.smart.eco.budget.repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import sn.smart.eco.budget.model.BudgetPlanLevel;
import sn.smart.eco.commonjpa.model.LevelType;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;

public class BudgetPlanLevelRepositoryImpl implements BudgetPlanLevelRepositoryCustom {
  @Autowired
  private MongoTemplate template;
  @Value("${gafico.leveltype.depth.max ?: 4}")
  private int maxDepth;

  @Override
  public Long calculateNextCode(LevelType level) {
    MongoCollection<Document> collection =
        template.getCollection(template.getCollectionName(BudgetPlanLevel.class));

    Document result = collection.find().max(Filters.eq("level.depth", level.getDepth())).first();
    if (result.containsKey("code")) {
      Long code = result.get("code", Long.class);
      return code + 1;
    }

    return null;
  }

}
