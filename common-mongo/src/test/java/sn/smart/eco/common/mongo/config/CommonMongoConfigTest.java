package sn.smart.eco.common.mongo.config;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@Configuration
@EnableMongoRepositories("sn.smart.eco.common.mongo.repositories")
@EnableTransactionManagement
@ComponentScan("sn.smart.eco.common.mongo")
// @PropertySource("classpath:config.properties")
public class CommonMongoConfigTest {
  private static final String MONGO_DB_URL = "localhost";
  private static final String MONGO_DB_NAME = "embeded_db";

  @Bean
  public MongoTemplate mongoTemplate() throws IOException {
    EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
    mongo.setBindIp(MONGO_DB_URL);
    MongoClient mongoClient = mongo.getObject();
    MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
    return mongoTemplate;
  }
}
