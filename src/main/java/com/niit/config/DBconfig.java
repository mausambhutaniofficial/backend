package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Coupon;
import com.niit.model.OrderDetail;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;



@Configuration
@EnableTransactionManagement
public class DBconfig {
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource datasrc=new DriverManagerDataSource();
		datasrc.setDriverClassName("org.h2.Driver");
		datasrc.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasrc.setUsername("sa");
		datasrc.setPassword("");
		
		System.out.println("Data Sorce object created");   //sys outs are for Testing purposes
		return datasrc;
	}
	
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(){
		Properties prop=new Properties();
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder sessfactbulid=new LocalSessionFactoryBuilder(getH2DataSource());
		sessfactbulid.addProperties(prop);
		sessfactbulid.addPackage("com.niit.model");
		sessfactbulid.addAnnotatedClass(Category.class);
		sessfactbulid.addAnnotatedClass(Supplier.class);
		sessfactbulid.addAnnotatedClass(Product.class);
		sessfactbulid.addAnnotatedClass(UserDetail.class);
		sessfactbulid.addAnnotatedClass(CartItem.class);
		sessfactbulid.addAnnotatedClass(OrderDetail.class);
		
		sessfactbulid.addAnnotatedClass(Coupon.class);
		SessionFactory sessfact=sessfactbulid.buildSessionFactory();
		
		System.out.println("Session factory object created");
		return sessfact;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessfact){
		
		System.out.println("Hibernate Transaction object created");
		return new HibernateTransactionManager(sessfact);
	}
}
