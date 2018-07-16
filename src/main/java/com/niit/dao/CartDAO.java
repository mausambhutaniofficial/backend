package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartDAO {
	public boolean addCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public List<CartItem> showCartItems(String username);
	public CartItem getCartItem(int CartitemID);
}