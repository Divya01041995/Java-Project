package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;

public class CartDAOTestCase 
{
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Test
	public void addCartItemTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setProductId(4);
		cartItem.setProductName("Samsung J5");
		cartItem.setQuantity(8);
		cartItem.setUsername("");
		cartItem.setPrice(10000);
		cartItem.setStatus("NA");

      assertTrue("Problem in adding CartItem",cartDAO.addCartItem(cartItem));
		
		
	}
	
	

}
