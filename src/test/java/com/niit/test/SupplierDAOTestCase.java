package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierDAOTestCase {

	static SupplierDAO suppDAO;
	@BeforeClass
	public static void executeFirst(){
		System.out.println("we are in execute first method");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		SupplierDAO suppDAO =(SupplierDAO)context.getBean("suppDAO" );
		if (suppDAO==null){
			System.out.println("supplier null");
			
		}
/*		Supplier supplier=new Supplier();
		supplier.setSuppId(2);
		supplier.setSupName("S1");
		supplier.setSupAddr("A1");
		if (suppDAO==null){
			System.out.println("category null 22");
		}
	System.out.println(supplier.getSuppId());
	System.out.println(supplier.getSupName());
	System.out.println(supplier.getSupAddr());
	suppDAO.addSupplier(supplier);
	}*/	
	
	Supplier supplier=suppDAO.getSupplier(40);
	supplier.setSupName("S3");
	supplier.setSupAddr("A3");
	
	suppDAO.updateSupplier(supplier);
}
	@Ignore
	@Test
	public void addSupplierTest(){
		Supplier supplier=new Supplier();
		supplier.setSuppId(2);
		supplier.setSupName("S1");
		supplier.setSupAddr("A1");
		if (suppDAO==null){
			System.out.println("category null 2");
		}
		System.out.println(supplier.getSuppId());
		System.out.println(supplier.getSupName());
		System.out.println(supplier.getSupAddr());
		assertTrue("problem in adding category:",suppDAO.addSupplier(supplier));	
	}
	
	@Test
	public void updateSupplierTest(){
			Supplier supplier=new Supplier();
			supplier.setSupName("S3");
			supplier.setSupAddr("A3");
			
			assertTrue("Problem in updating",suppDAO.updateSupplier(supplier));
		}

	@Ignore
	@Test
	public void deleteSupplierTest(){
		System.out.println("we are in delete supplier test case");
		Supplier supplier=suppDAO.getSupplier(1);
		System.out.println(supplier.getSuppId());
		System.out.println(supplier.getSupName());
		System.out.println(supplier.getSupAddr());
		assertTrue("problem in deleting",suppDAO.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void listSupplierTest(){
		List<Supplier> listSupplier=suppDAO.listsupplier();
		assertTrue("Problem in list supplier",listSupplier.size()>0);
		for(Supplier supplier:listSupplier){
			System.out.println(supplier.getSuppId()+"::");
			System.out.println(supplier.getSupName()+"::");
			System.out.println(supplier.getSupAddr()+"::");
		}
	}
}

	


