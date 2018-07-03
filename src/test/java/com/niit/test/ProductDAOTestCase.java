package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class ProductDAOTestCase {
	static ProductDAO productDAO;
	@BeforeClass
	public static void executeFirst(){
		System.out.println("we are in execute first method");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO =(ProductDAO)context.getBean("productDAO" );
		
		
	/*	Product product=new Product();
		product.setProdName("Samsung J7");
		product.setProdDesc("Samsung Mobile with 4G Features");
		product.setPrice(53000);
		product.setStock(120);
		product.setCategoryId(1);
		product.setSuppId(1);
		
		assertTrue("Problem in adding product",productDAO.addProduct(product));
	}*/
		
		/*System.out.println("we are in delete product test case");
		Product product=productDAO.getProduct(41);
		System.out.println(product.getProdId());
		System.out.println(product.getProdName());
		System.out.println(product.getProdDesc());
		assertTrue("problem in deleting",productDAO.deleteProduct(product));
	}*/
		List<Product> listProduct=productDAO.listprod();
		assertTrue("Problem in list categories",listProduct.size()>0);
		for(Product product:listProduct){
			System.out.println(product.getProdId()+"::");
			System.out.println(product.getProdName()+"::");
			System.out.println(product.getProdDesc()+"::");
		}
	}
	
	@Test
	public void addProductTestCase(){
		Product product=new Product();
		product.setProdName("Samsung J7");
		product.setProdDesc("Samsung Mobile with 4G Features");
		product.setPrice(53000);
		product.setStock(120);
		product.setCategoryId(1);
		product.setSuppId(1);
		
		assertTrue("Problem in adding product",productDAO.addProduct(product));
	}
	
   @Ignore
	@Test
	public void deleteCategoryTest(){
		System.out.println("we are in delete product test case");
		Product product=productDAO.getProduct(1);
		System.out.println(product.getProdId());
		System.out.println(product.getProdName());
		System.out.println(product.getProdDesc());
		assertTrue("problem in deleting",productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public void listProductTest(){
		List<Product> listProduct=productDAO.listprod();
		assertTrue("Problem in list categories",listProduct.size()>0);
		for(Product product:listProduct){
			System.out.println(product.getProdId()+"::");
			System.out.println(product.getProdName()+"::");
			System.out.println(product.getProdDesc()+"::");
		}
}
}
