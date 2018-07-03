package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;


public class DBconfig_Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	CategoryDAO categoryDAO =(CategoryDAO)context.getBean("categoryDAO" );
		Category categ=new Category();
		//categ.setCategoryId(1);
		categ.setCategoryName("Mobiles");
		categ.setCategoryDesc("Mobile Phones $ iPhones");
		categoryDAO.addCategory(categ);
		System.out.println("Category Object saved");		
	}
}
