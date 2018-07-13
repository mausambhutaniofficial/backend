package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;


@Repository("catDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessfact;
	
	public boolean addCategory(Category categ) {
		System.out.println("we are in add category method");
		try{
			sessfact.getCurrentSession().save(categ);
			System.out.println("successfully added the category");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean updateCategory(Category categ) {
		
		try{
			sessfact.getCurrentSession().update(categ);
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	public boolean deleteCategory(Category categ) {

		try{
			sessfact.getCurrentSession().delete(categ);
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	
	public Category getCategory(int categoryId) {
	
		try{
			System.out.println("we are in getactegory methd ");
			Session sess=sessfact.openSession();
			Category categ=(Category)sess.get(Category.class, categoryId);
			sess.close();
			return categ;
		}
		
		catch(Exception e){
		
			return null;
		}
	}

	public List<Category> listcateg() {
		try{
			System.out.println("we are in list category method *******************S");
			Session sess=sessfact.openSession();
			Query query=sess.createQuery("From Category");
			List<Category> listcateg=query.list();
		sess.close();
			return listcateg;
		}
		catch(Exception e){
	
		return null;
		}
	}

	
}
