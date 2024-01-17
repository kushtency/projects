package dev.spring.springdata.hibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("dev.spring.springdata.hibernate")
@PropertySource("/WEB-INF/resources/database.properties")
public class DatabaseConfig {

	private final Environment environment;

	@Autowired
	public DatabaseConfig(Environment environment) {
		this.environment = environment;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setPackagesToScan(new String[] { "dev.spring.springdata.hibernate" });
		bean.setHibernateProperties(hibernateProperties());
		return bean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactoryBean().getObject());
		return manager;
	}

	private final Properties hibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		props.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		return props;
	}

}
