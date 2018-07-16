package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;

public class CartDAOTestCase {

	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
		
		/*List<CartItem> cartItems=cartDAO.showCartItems("sarthak");
		assertTrue("Problem in showing CartItem:",cartItems.size()>0);
		for(CartItem cartItem:cartItems) {
			System.out.print(cartItem.getProdName()+":::");
			System.out.print(cartItem.getQuantity()+":::");
			System.out.print(cartItem.getPrice()+":::");
			System.out.println(cartItem.getStatus()+":::");
*/	
		/*CartItem cartItem=new CartItem();
		cartItem.setProdId(203);
		cartItem.setProdName("sonata");
		cartItem.setQuantity(2);
		cartItem.setUserName("new");
		cartItem.setPrice(123);
		cartItem.setStatus("added");
		cartDAO.addCartItem(cartItem);
	*/	
	/*	CartItem cartItem=cartDAO.getCartItem(236);
		//assertNotNull("Problem in getting CartItem",cartItem);
		System.out.print(cartItem.getProdName()+":::");
		System.out.print(cartItem.getQuantity()+":::");
		System.out.print(cartItem.getPrice()+":::");
		System.out.println(cartItem.getStatus()+":::");
	*/
		/*CartItem cartItem=cartDAO.getCartItem(236);
		cartDAO.deleteCartItem(cartItem);*/
		/*CartItem cartItem=cartDAO.getCartItem(237);
		cartItem.setQuantity(40);
		cartDAO.updateCartItem(cartItem);
*/
		List<CartItem> cartItems=cartDAO.showCartItems("sarthak");
	/*	assertTrue("Problem in showing CartItem:",cartItems.size()>0);*/
		
		for(CartItem cartItem:cartItems) {
			System.out.print(cartItem.getProdName()+":::");
			System.out.print(cartItem.getQuantity()+":::");
			System.out.print(cartItem.getPrice()+":::");
			System.out.println(cartItem.getStatus()+":::");
	}
	}
	

@Test
@Ignore
public void addCartItemTest() {
	CartItem cartItem=new CartItem();
	cartItem.setProdId(208);
	cartItem.setProdName("titan");
	cartItem.setQuantity(2);
	cartItem.setUserName("sarthak");
	cartItem.setPrice(3456);
	cartItem.setStatus("NA");
	assertTrue("Problem in adding CartItem",cartDAO.addCartItem(cartItem));
}


@Test
public void showCartItems() {
	
	List<CartItem> cartItems=cartDAO.showCartItems("sarthak");
	assertTrue("Problem in showing CartItem:",cartItems.size()>0);
	for(CartItem cartItem:cartItems) {
		System.out.print(cartItem.getProdName()+":::");
		System.out.print(cartItem.getQuantity()+":::");
		System.out.print(cartItem.getPrice()+":::");
		System.out.println(cartItem.getStatus()+":::");
	}
}

	@Ignore
@Test
public void getCartItemTestCase() {
	CartItem cartItem=cartDAO.getCartItem(15);
	assertNotNull("Problem in getting CartItem",cartItem);
	System.out.print(cartItem.getProdName()+":::");
	System.out.print(cartItem.getQuantity()+":::");
	System.out.print(cartItem.getPrice()+":::");
	System.out.println(cartItem.getStatus()+":::");

}
@Ignore
@Test
public void deleteCartItemTestCase(){
	CartItem cartItem=cartDAO.getCartItem(15);
	assertTrue("Problem in deleting",cartDAO.deleteCartItem(cartItem));

}
@Ignore
@Test
public void updateCartItemTestCase(){
CartItem cartItem=cartDAO.getCartItem(15);
cartItem.setQuantity(40);
assertTrue("Problem in updating CartItem",cartDAO.updateCartItem(cartItem));

}
	


}
