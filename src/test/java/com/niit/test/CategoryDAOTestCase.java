package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;
public class CategoryDAOTestCase {

	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst(){
		System.out.println("we are in execute first method");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		CategoryDAO categoryDAO =(CategoryDAO)context.getBean("catDAO" );
		if (categoryDAO==null){
			System.out.println("category null");
			
		}
		/*Category categ=new Category();
		categ.setCategoryId(2);
		categ.setCategoryName("Shirts");
		categ.setCategoryDesc("VanHuesen Shirt");
		if (categoryDAO==null){
			System.out.println("category null 22");
		}
	System.out.println(categ.getCategoryId());
	System.out.println(categ.getCategoryName());
	System.out.println(categ.getCategoryDesc());
	categoryDAO.addCategory(categ);*/
		
		/*List<Category> listCateg=categoryDAO.listcateg();
		System.out.println("we are checking list of categories");
		for(Category categ:listCateg){
			System.out.println(categ.getCategoryId()+"::");
			System.out.println(categ.getCategoryName()+"::");
			System.out.println(categ.getCategoryDesc()+"::");
		}*/
		
		/*Category category=categoryDAO.getCategory(50);
		System.out.println(category.getCategoryId());
		System.out.println(category.getCategoryName());
		System.out.println(category.getCategoryDesc());*/
		
		/*System.out.println("we are checking update method");
		Category category=categoryDAO.getCategory(50);
		category.setCategoryName("trousers");
		categoryDAO.updateCategory(category);*/
		
		System.out.println("we are checking delete method");
		Category category=categoryDAO.getCategory(1);
		categoryDAO.deleteCategory(category);
	}	
		@Ignore
		@Test
	public void addCategoryTest(){
		Category categ=new Category();
		categ.setCategoryId(2);
		categ.setCategoryName("T Shirts");
		categ.setCategoryDesc("VanHue");
		if (categoryDAO==null){
			System.out.println("category null 22");
		}
	System.out.println(categ.getCategoryId());
	System.out.println(categ.getCategoryName());
	System.out.println(categ.getCategoryDesc());
		assertTrue("problem in adding category:",categoryDAO.addCategory(categ));	
	}
	
		@Ignore
		@Test
	public void updateCategoryTest(){
			Category categ=new Category();
			categ.setCategoryName("Samsung");
			categ.setCategoryDesc("4G phone");
			
			assertTrue("Problem in updating",categoryDAO.updateCategory(categ));
		}
@Ignore
	@Test
	public void deleteCategoryTest(){
		System.out.println("we are in delete category test case");
		Category categ=categoryDAO.getCategory(1);
		System.out.println(categ.getCategoryId());
		System.out.println(categ.getCategoryName());
		System.out.println(categ.getCategoryDesc());
		assertTrue("problem in deleting",categoryDAO.deleteCategory(categ));
	}
	@Ignore
	@Test
	public void listCategoriesTest(){
		List<Category> listCateg=categoryDAO.listcateg();
		assertTrue("Problem in list categories",listCateg.size()>0);
		for(Category categ:listCateg){
			System.out.println(categ.getCategoryId()+"::");
			System.out.println(categ.getCategoryName()+"::");
			System.out.println(categ.getCategoryDesc()+"::");
		}
	}
}

	


