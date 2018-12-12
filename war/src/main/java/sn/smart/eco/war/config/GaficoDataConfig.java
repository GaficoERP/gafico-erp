package sn.smart.eco.war.config;

import sn.smart.eco.war.filters.CorsHeaderFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(value = {GaficoJpaConfig.class, GaficoMongoConfig.class})
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan("sn.smart.eco")
// @Profile("prod")
public class GaficoDataConfig {

  @Bean
  public CorsHeaderFilter getCorsHeaderFilter() {
    return new CorsHeaderFilter();
  }

}
