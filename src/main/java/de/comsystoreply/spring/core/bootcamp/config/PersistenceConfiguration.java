package de.comsystoreply.spring.core.bootcamp.config;

public class PersistenceConfiguration {

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(Environment environment) {
        // provides a HibernatePersistenceProvider
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setGenerateDdl(environment.getProperty("spring.jpa.generate-ddl", Boolean.TYPE, false));
        bean.setShowSql(environment.getProperty("spring.jpa.show-sql", Boolean.TYPE, false));

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
        bean.setJpaVendorAdapter(jpaVendorAdapter);

        return bean;
    }
}
