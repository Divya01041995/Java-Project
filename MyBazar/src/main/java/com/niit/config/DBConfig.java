package com.niit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

import java.util.Properties;

import javax.sql.DataSource;

import org.h2.engine.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{
	
	//to create beans
	
		@Bean(name="dataSource")
		public DataSource getH2DataSource() 
		{
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("org.h2.Driver");
		    dataSource.setUrl("jdbc:h2:tcp://localhost/~/divya");
		    dataSource.setUsername("sa");
		    dataSource.setPassword("");
		    System.out.println("Data source object is created");
		    return dataSource;
		}
		/*
		 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
		 * <property name="dataSource" ref="dataSource">
		 */
		@Bean(name="sessionfactory")
		public SessionFactory getSessionFactory()
		{
			
			Properties properties=new Properties();
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			properties.put("show_sql","true");
			properties.put("format_sql","true");
			LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		    sessionFactoryBuilder.addProperties(properties);
		
		    sessionFactoryBuilder.addAnnotatedClass(Category.class);
		    sessionFactoryBuilder.addAnnotatedClass(Product.class);
		    sessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		    sessionFactoryBuilder.addAnnotatedClass(User.class);


		    SessionFactory sessionFactory= sessionFactoryBuilder.buildSessionFactory();
		System.out.println("Session object is created");
		return sessionFactory;
		}
		  
		@Bean
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
			{
				System.out.println("Hibernet transaction object is created");
			return new HibernateTransactionManager(sessionFactory);
		}
	}
