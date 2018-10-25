package sn.smart.eco.budget.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.io.IOException;

public class BudgetUtils {

  public static void importJSON(MongoTemplate mongoTemplate, String collection, String file) {
    try {
      for (String line : FileUtils.readLines(new File(file), "utf8")) {
        mongoTemplate.insert(line, collection);
      }
    } catch (IOException e) {
      throw new RuntimeException("Could not import file: " + file, e);
    }
  }
}
