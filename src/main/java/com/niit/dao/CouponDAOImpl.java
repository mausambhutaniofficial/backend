package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;
import com.niit.model.Coupon;

@Repository("couponDAO")
@Transactional
public class CouponDAOImpl implements CouponDAO {

	@Autowired 
	SessionFactory sessfact;

	public boolean addCoupon(Coupon coupon) {
		try{
			sessfact.getCurrentSession().save(coupon);
			System.out.println("successfully added the coupon");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean updateCoupon(Coupon coupon) {
		try{
			sessfact.getCurrentSession().update(coupon);
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	public boolean deleteCoupon(Coupon coupon) {
		try{
			sessfact.getCurrentSession().delete(coupon);
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	
	public List<Coupon> listcoupon() {
		try{
			System.out.println("we are in list coupon method *******************S");
			Session sess=sessfact.openSession();
			Query query=sess.createQuery("From Coupon");
			List<Coupon> listcoupon=query.list();
		
			return listcoupon;
		}
		catch(Exception e){
	
		return null;
		}
		
		
	}

	public Coupon getCoupon(String couponName) {
		try{
			System.out.println("we are in getcoupon methd ");
			Session sess=sessfact.getCurrentSession();
		Coupon coupon=(Coupon)sess.get(Coupon.class, couponName);
		System.out.println(coupon.getCouponName());
			System.out.println(coupon.getCouponValue());
			System.out.println(coupon.getCouponDesc());
			return coupon;
		}
		
		catch(Exception e){
		
			return null;
		
	
	
	}



}


}