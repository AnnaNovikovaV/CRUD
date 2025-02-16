package web.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class AppConfig {

   @Autowired
   private Environment env;

   @Bean
   public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
      dataSource.setUrl(env.getRequiredProperty("db.url"));
      dataSource.setUsername(env.getRequiredProperty("db.username"));
      dataSource.setPassword(env.getRequiredProperty("db.password"));
      return dataSource;
   }


   private Properties hibernateProperties() {
      Properties properties = new Properties();
      properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
      properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
      properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
      return properties;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(getDataSource());
      em.setPackagesToScan("web.model");
      em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      em.setJpaProperties(hibernateProperties());
      return em;
   }

   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
      return transactionManager;
   }
}
