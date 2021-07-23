package de.comsystoreply.spring.core.bootcamp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:/application.properties")
public class DataSourceConfiguration {

  @Bean
  public DataSource dataSource(@Value("${spring.datasource.url}") String url,
                               @Value("${spring.datasource.username}") String username,
                               @Value("${spring.datasource.password}") String password) {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriverClass(org.postgresql.Driver.class);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }


  @Bean
  public JpaVendorAdapter jpaVendorAdapter(Environment environment) {
    // provides a HibernatePersistenceProvider
    HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
    bean.setGenerateDdl(environment.getProperty("spring.jpa.generate-ddl", Boolean.TYPE, true));
    bean.setShowSql(environment.getProperty("spring.jpa.show-sql", Boolean.TYPE, true));

    return bean;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
          DataSource dataSource,
          JpaVendorAdapter jpaVendorAdapter
  ) {
    // manages the PersistenceUnits
    LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    bean.setDataSource(dataSource);
    bean.setPackagesToScan("de.comsystoreply");
    bean.setJpaVendorAdapter(jpaVendorAdapter);

    return bean;
  }
}
