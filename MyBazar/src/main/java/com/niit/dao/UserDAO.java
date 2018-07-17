package com.niit.dao;

import com.niit.model.UserDetail;

public interface UserDAO
{
	
	public boolean registerUser(UserDetail userDetail);
	public boolean updateUserDetail(UserDetail userDetail);
	public UserDetail getUserDetail(String username);
	

}
