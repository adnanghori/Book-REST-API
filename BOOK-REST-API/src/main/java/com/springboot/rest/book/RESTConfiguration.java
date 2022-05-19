package com.springboot.rest.book;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.springboot.rest.book.model.Author;
import com.springboot.rest.book.model.Book;

@Configuration
@ComponentScan(basePackages = "com.springboot.rest.book")
@EnableWebMvc
@EnableTransactionManagement(proxyTargetClass = true)
@EntityScan(basePackages = "cpm.springboot.rest.book")
public class RESTConfiguration  {
//	@Value("${db.driver}")
//    private String DRIVER;
//
//    @Value("${db.password}")
//    private String PASSWORD;
//
//    @Value("${db.url}")
//    private String URL;
//
//    @Value("${db.username}")
//    private String USERNAME;
//
//    @Value("${hibernate.dialect}")
//    private String DIALECT;
//
//    @Value("${hibernate.show_sql}")
//    private String SHOW_SQL;
//
//    @Value("${hibernate.hbm2ddl.auto}")
//    private String HBM2DDL_AUTO;
//
//    @Value("${entitymanager.packagesToScan}")
//    private String PACKAGES_TO_SCAN;
//		
	@Bean("dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/restbook");
		dataSource.setUsername("root");
		dataSource.setPassword("Macbookair03");
		return dataSource;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		localSessionFactoryBean.setHibernateProperties(properties);
		localSessionFactoryBean.setAnnotatedClasses(Book.class,Author.class);
		return localSessionFactoryBean;
	}
	
	@Bean("hibernateTemplate")
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTemplate;
	}
	
	@Bean("transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTransactionManager;
	}
	
	}
