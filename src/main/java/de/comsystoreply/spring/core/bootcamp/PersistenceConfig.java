package de.comsystoreply.spring.core.bootcamp;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/datasource.properties")
public class PersistenceConfig {

    @Bean
    DataSourceProperties dataSourceProperties(Environment environment) {
        return new DataSourceProperties(
                environment.getRequiredProperty("bootcamp.datasource.url"),
                environment.getRequiredProperty("bootcamp.datasource.user"),
                environment.getRequiredProperty("bootcamp.datasource.password")
        );
    }

    @Bean
    DataSource dataSource(DataSourceProperties dataSourceProperties) throws SQLException {
        var dbDriver = DriverManager.getDriver(dataSourceProperties.jdbcUrl());

        return new SimpleDriverDataSource(
                dbDriver,
                dataSourceProperties.jdbcUrl(),
                dataSourceProperties.userName(),
                dataSourceProperties.password()
        );
    }

    @Bean
    FactoryBean<EntityManagerFactory> entityManagerFactoryBean(DataSource dataSource) {
        var entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(Application.class.getPackageName());

        return entityManagerFactoryBean;
    }

    @Bean
    TransactionManager transactionContextManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    Flyway flyway(DataSource dataSource) {
        var flyway = Flyway.configure()
                .dataSource(dataSource)
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();

        return flyway;
    }

    public static record DataSourceProperties(
            String jdbcUrl,
            String userName,
            String password
    ) {
    }
}
