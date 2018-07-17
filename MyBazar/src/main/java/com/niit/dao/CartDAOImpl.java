package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCartItem(CartItem cartItem) 
	{
       try
       {
    	   sessionFactory.getCurrentSession().save(cartItem);
    	   return true;
       }
       catch(Exception e)
       {
		   return false;
       }   
	}

	@Override
	public boolean updateCartItem(CartItem cartItem)
	{
		 try
	       {
	    	   sessionFactory.getCurrentSession().update(cartItem);
	    	   return true;
	       }
	       catch(Exception e)
	       {
			   return false;
	       }   
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem)
	{
		 try
	       {
	    	   sessionFactory.getCurrentSession().delete(cartItem);
	    	   return true;
	       }
	       catch(Exception e)
	       {
			   return false;
	       }   
	}

	@Override
	public List<CartItem> showCartItems(String username) 
	{
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from CartItem where username=:myusername and status=:NA");
        query.setParameter("myusername",username);
        List<CartItem> listCartItems=(List<CartItem>)query.list();
		return listCartItems;
	}

	@Override
	public CartItem getCartItem(int cartItemId) 
	{
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
		session.close();
		return cartItem;
	}

	
	
}
