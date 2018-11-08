package sn.smart.eco.commonjpa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/*
 * @Configuration
 * 
 * @EnableJpaRepositories("sn.smart.eco.common.jpa")
 * 
 * @EnableTransactionManagement
 * 
 * @PropertySource("classpath:application.properties")
 * 
 * @ComponentScan(basePackages = {"sn.smart.eco.common.jpa"}, excludeFilters
 * = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CommonConfigRest.class))
 * 
 * @Profile("prod")
 */
public class CommonConfig {

  // @Bean
  public DataSource dataSource(@Value("${spring.datasource.driver}") String driver, //
      @Value("${spring.datasource.url}") String url, //
      @Value("${spring.datasource.username}") String user, //
      @Value("${spring.datasource.password}") String pwd) {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(url);
    config.setUsername(user);
    config.setPassword(pwd);
    config.setDriverClassName(driver);
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    HikariDataSource source = new HikariDataSource(config);

    return source;
  }

  // @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setShowSql(true);
    adapter.setGenerateDdl(true);
    adapter.setDatabase(Database.POSTGRESQL);

    Properties props = new Properties();
    props.setProperty("hibernate.format_sql", "true");
    props.setProperty("hibernate.hbm2ddl.auto", "update");

    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    emfb.setDataSource(dataSource);
    emfb.setPackagesToScan("sn.smart.eco.common.jpa.model");
    emfb.setJpaProperties(props);
    emfb.setJpaVendorAdapter(adapter);

    return emfb;
  }

  // @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    return new JpaTransactionManager(emf);
  }
}
