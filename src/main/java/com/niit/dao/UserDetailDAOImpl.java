package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.UserDetail;

@Repository("userdetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessfact;
	public boolean registerUser(UserDetail userdetail) {
		System.out.println("we are in register user method");
		try{
			sessfact.getCurrentSession().save(userdetail);
			System.out.println("successfully registered ");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}


	public boolean updateUserDetail(UserDetail userdetail) {

		try{
			sessfact.getCurrentSession().update(userdetail);
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}


	public UserDetail getUserDetail(String userName) {

		try{
			System.out.println("we are in get user  methd");
			Session sess=sessfact.getCurrentSession();
			UserDetail userdetail=(UserDetail)sess.get(UserDetail.class, userName);
			
			return userdetail;
		}
		
		catch(Exception e){
		
			return null;
		}
	}
}
