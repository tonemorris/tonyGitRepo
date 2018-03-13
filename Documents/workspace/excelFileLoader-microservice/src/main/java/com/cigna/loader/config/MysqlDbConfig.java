package com.cigna.loader.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory",
    transactionManagerRef = "mysqlTransactionManager", basePackages = {"com.cigna.loader.repository"})
public class MysqlDbConfig {

  @Bean(name = "mysqlDataSource")
  @ConfigurationProperties(prefix = "mysql.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "mysqlEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("mysqlDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.cigna.loader.domain").persistenceUnit("mysql")
        .build();
  }

  @Bean(name = "mysqlTransactionManager")
  public PlatformTransactionManager mysqlTransactionManager (
      @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory mysqlEntityManagerFactory) {
    return new JpaTransactionManager(mysqlEntityManagerFactory);
  }

}
