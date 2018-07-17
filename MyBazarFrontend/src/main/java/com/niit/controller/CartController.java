package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.Product;

@Controller
public class CartController 
{
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/AddToCart/{productId}")
	public String addCartItem(@RequestParam("quantity") int quantity,@PathVariable("productId")int productId,HttpSession session,Model m )
	{
		Product product=productDAO.getProduct(productId);
		
		CartItem cartItem=new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getPrice());
		
		String username = "DummyUser";
		cartItem.setUsername(username);


		
	     return "Cart";
	}
}
