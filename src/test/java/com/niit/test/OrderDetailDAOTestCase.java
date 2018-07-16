package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OrderDetailDAO;
import com.niit.model.OrderDetail;

public class OrderDetailDAOTestCase {

	static OrderDetailDAO orderDetailDAO;
	
	@BeforeClass
	public static void configure(){
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		orderDetailDAO=(OrderDetailDAO)context.getBean("orderDetailDAO");
	}
	
	@Ignore
	@Test
	public void insertOrderDetailTest(){
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setUsername("q");
		orderDetail.setTotalPurchaseAmount(45000);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPaymentMode("CC");
		
		assertTrue("Problem in inserting OrderDetail:",orderDetailDAO.insertOrderDetail(orderDetail));
	}
	
	@Test
	public void updateCartItemsStatus(){
		assertTrue("Problem in updating cart items",orderDetailDAO.updateOrderDetail("q"));
	}
}
