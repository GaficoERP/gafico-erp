package sn.smart.eco.war.config;

import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("sn.smart.eco.*.mongo.repositories")
public class GaficoMongoConfig {

  @Bean
  public MongoClient mongoClient(String dbUrl) {
    return new MongoClient(dbUrl);
  }

  @Bean
  public MongoTemplate mongoTemplate(@Value("${spring.mongo.database.url}") String dbUrl,
      @Value("${spring.mongo.database.name}") String dbName) {
    return new MongoTemplate(mongoClient(dbUrl), dbName);
  }
}
