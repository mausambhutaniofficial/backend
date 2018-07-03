package com.niit.dao;

import com.niit.model.UserDetail;

public interface UserDetailDAO {

	public boolean registerUser(UserDetail userdetail);
	public boolean updateUserDetail(UserDetail userdetail);
	public UserDetail getUserDetail(String userName);
}
