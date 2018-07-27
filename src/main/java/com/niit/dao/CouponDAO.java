package com.niit.dao;

import java.util.List;

import com.niit.model.Coupon;

public interface CouponDAO {
	public boolean addCoupon(Coupon coupon);
	public boolean updateCoupon(Coupon coupon);
	public boolean deleteCoupon(Coupon coupon);
	/*public int getCouponIdByName(String couponName);*/
	public Coupon getCoupon(String couponName);
	public List<Coupon> listcoupon();
}