package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CouponDAO;
import com.niit.model.CartItem;
import com.niit.model.Coupon;

public class CouponDAOTestCase {
	static CouponDAO couponDAO;
	
	@BeforeClass
	public static void executeFirst(){
	
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		couponDAO =(CouponDAO)context.getBean("couponDAO");
	}
	@Ignore
	@Test
	public void addCouponTest() {
		Coupon coupon=new Coupon();
		coupon.setCouponName("30percent");
		coupon.setCouponValue(20);
		assertTrue("Problem in adding CartItem",couponDAO.addCoupon(coupon));
	}
	@Ignore
	@Test
	public void deleteCouponTest(){
		Coupon coupon=couponDAO.getCoupon("20percent");
		assertTrue("Problem in deleting",couponDAO.deleteCoupon(coupon));

	}
	@Ignore
	@Test
	public void updateCouponTest(){
	Coupon coupon=couponDAO.getCoupon("20percent");
	coupon.setCouponName("30percent");
	coupon.setCouponValue(30);
	assertTrue("Problem in updating Coupon",couponDAO.updateCoupon(coupon));
	}
	
	@Test
	public void getCouponTestCase() {
		Coupon coupon=couponDAO.getCoupon("30percent");
		assertNotNull("Problem in getting Coupon",coupon);
		System.out.print(coupon.getCouponName()+":::");
		System.out.print(coupon.getCouponValue()+":::");
	}
	@Ignore
	@Test
	public void listCouponsTestCase() {
		
		List<Coupon> coupons=couponDAO.listcoupon();
		assertTrue("Problem in showing Coupons:",coupons.size()>0);
		for(Coupon coupon:coupons) {
			System.out.print(coupon.getCouponName()+":::");
			System.out.print(coupon.getCouponValue()+":::");	
		}
	}
	
	
}
