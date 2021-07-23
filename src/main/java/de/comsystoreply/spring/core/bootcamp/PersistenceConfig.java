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
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement // enable database transaction support
@PropertySource("classpath:/datasource.properties") // load properties into environment
public class PersistenceConfig {

    @Bean
    DataSourceProperties dataSourceProperties(Environment environment) {
        /*
         * Here we just create a dedicated Spring for the DB configuration.
         * With this we do not need to remember how the config properties are called and can work on a higher level of
         * abstraction when working with the DB configuration.
         */

        return new DataSourceProperties(
                environment.getRequiredProperty("bootcamp.datasource.url"),
                environment.getRequiredProperty("bootcamp.datasource.user"),
                environment.getRequiredProperty("bootcamp.datasource.password")
        );
    }

    @Bean
    @Profile("!connection-pool")
    DataSource dataSource(DataSourceProperties dataSourceProperties) throws SQLException {
        /*
         * All JDBC driver on the classpath are registered with the DriverManage.
         * As the type of the database is encoded in the JDBC connection String, we can check as the manager for a
         * matching driver to use.
         */
        var dbDriver = DriverManager.getDriver(dataSourceProperties.jdbcUrl());

        /*
         * Create a very simple DataSource using the connection URL and credentials from the properties file.
         *
         * (!)
         * For production code you most likely a connection pool. See example below.
         */
        return new SimpleDriverDataSource(
                dbDriver,
                dataSourceProperties.jdbcUrl(),
                dataSourceProperties.userName(),
                dataSourceProperties.password()
        );
    }

    @Bean
    @Profile("connection-pool")
    DataSource connectionPoolDataSource(DataSourceProperties dataSourceProperties) {
        /*
         * If you do not use a connection pool you are likely to run into easily avoidable performance issues.
         * Establishing a DB connection is an expensive operation. To avoid having to do this often, it is common
         * practice to use a connection pool.
         */
        var config = new HikariConfig();
        config.setJdbcUrl(dataSourceProperties.jdbcUrl());
        config.setUsername(dataSourceProperties.userName());
        config.setPassword(dataSourceProperties.password());

        return new HikariDataSource(config);
    }

    @Bean
    FactoryBean<EntityManagerFactory> entityManagerFactoryBean(DataSource dataSource) {
        /*
         * EntityManager is the JPA abstraction used to interact with the database.
         */

        var entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        /*
         * Configures scanning for JPA annotations on the class path.
         * By default JPA expects a persistence.xml file to be present. But we want to just annotate our classes and not
         * create any XML files.
         *
         * The root package to scan is configured using a class object instead of a plain String to make to code more
         * resilience to package renaming.
         */
        entityManagerFactoryBean.setPackagesToScan(Application.class.getPackageName());

        return entityManagerFactoryBean;
    }

    @Bean
    TransactionManager transactionContextManager(DataSource dataSource) {
        /*
         * The TransactionManager is used to manage database transactions.
         * We do not have to interact with it manually because we use Spring's transaction support based on AOP and the
         * @Transactional annotation.
         */

        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    Flyway flyway(DataSource dataSource) {
        /*
         * We can use Flyway as an approach to version our DB schema.
         *
         * DB schema versions are located in src/main/resources/db/migration.
         */

        var flyway = Flyway.configure()
                .dataSource(dataSource)
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();

        return flyway;
    }

    /**
     * Stores the configuration of the database.
     */
    public static record DataSourceProperties(
            String jdbcUrl,
            String userName,
            String password
    ) {
    }
}
