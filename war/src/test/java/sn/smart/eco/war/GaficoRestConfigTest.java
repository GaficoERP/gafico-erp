package sn.smart.eco.war;

import sn.smart.eco.war.config.GaficoDataConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Profile("test")
@Configuration
@EnableWebMvc
@EnableJpaRepositories("sn.smart.eco.*.repositories")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"sn.smart.eco"},
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        value = GaficoDataConfig.class))
public class GaficoRestConfigTest {
  @Bean
  public DataSource dataSource() {
    // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)//
        // .addScript("sql/create-db-test.sql")//
        // .addScript("sql/insert-data-test.sql")//
        .build();
    return db;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setShowSql(true);
    adapter.setGenerateDdl(true);
    adapter.setDatabase(Database.HSQL);

    Properties props = new Properties();
    props.setProperty("hibernate.format_sql", "true");
    props.setProperty("hibernate.hbm2ddl.auto", "create");

    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    emfb.setDataSource(dataSource());
    emfb.setPackagesToScan("sn.smart.eco.*.model");
    emfb.setJpaProperties(props);
    emfb.setJpaVendorAdapter(adapter);

    return emfb;
  }


  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    return new JpaTransactionManager(emf);
  }
}
