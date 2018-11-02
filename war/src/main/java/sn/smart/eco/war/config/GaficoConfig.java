package sn.smart.eco.war.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc
@EnableJpaRepositories("sn.smart.eco.*.repositories")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan("sn.smart.eco")
//@Profile("prod")
public class GaficoConfig {
	@Bean
	  public DataSource dataSource(@Value("${spring.datasource.driver}") String driver, //
	      @Value("${spring.datasource.url}") String url, //
	      @Value("${spring.datasource.username}") String user, //
	      @Value("${spring.datasource.password}") String pwd) {
		System.out.println("##########dataSource#############");
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

	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

	    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setShowSql(true);
	    adapter.setGenerateDdl(true);
	    adapter.setDatabase(Database.H2);

	    Properties props = new Properties();
	    props.setProperty("hibernate.format_sql", "true");
	    props.setProperty("hibernate.hbm2ddl.auto", "update");

	    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
	    emfb.setDataSource(dataSource);
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
