package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
import com.niit.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl  implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserDetail userDetail) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
		return false;
	   }
	}

	@Override
	public boolean updateUserDetail(UserDetail userDetail)
	{
		
		try
		{
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
		return false;
	   }
	}

	@Override
	public UserDetail getUserDetail(String username)
	{
		
		try
		{
			Session session=sessionFactory.openSession();
			UserDetail userDetail=(UserDetail)session.get(UserDetail.class,username);
			session.close();
			return userDetail;
			
		}
		catch(Exception e)
		{
			return null;

		}
	}
	

}
