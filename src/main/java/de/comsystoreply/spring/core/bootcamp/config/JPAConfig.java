package de.comsystoreply.spring.core.bootcamp.config;

import de.comsystoreply.spring.core.bootcamp.Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

import static java.util.Map.entry;

/**
 * Configuration of the JPA persistence.
 */
@Configuration
@EnableTransactionManagement
public class JPAConfig {

    /**
     * Creates the {@link EntityManagerFactory} that will provide us with access to the persistence context.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            DataSource dataSource
    ) {
        var factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaDialect(new HibernateJpaDialect());
        factoryBean.setPackagesToScan(Application.class.getPackageName()); // find JPA entities via classpath scanning
        factoryBean.setJpaPropertyMap(Map.ofEntries(
                entry("hibernate.hbm2ddl.auto", "update"), // create DB tables based on Java classes
                entry("hibernate.show_sql", false),
                entry("hibernate.format_sql", false)
        ));

        return factoryBean;
    }

    /**
     * Create a transaction manager to for popper transaction support.
     */
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
