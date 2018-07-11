package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessfact;

	public boolean addProduct(Product product) {
		
		try{
			
			sessfact.getCurrentSession().save(product);
			return true;
		}
		
		catch(Exception e){
			
				return false;
		}
	}

	public boolean deleteProduct(Product product) {

		try{
			
			sessfact.getCurrentSession().delete(product);
			return true;
		}
		
		catch(Exception e){
			
				return false;
		}
	}

	public boolean updateProduct(Product product) {

		try{
			
			sessfact.getCurrentSession().update(product);
			return true;
		}
		
		catch(Exception e){
			
				return false;
		}
	}

	public Product getProduct(int prodId) {
		try{
			System.out.println("we are in get product methd ********************");
			Session sess=sessfact.openSession();
			Product product=(Product)sess.get(Product.class, prodId);
			sess.close();
			return product;
		}
		
		catch(Exception e){
		
			return null;
		}
	}

	public List<Product> listprod() {
		try{
			Session sess=sessfact.openSession();
			Query query=sess.createQuery("From Product");
			List<Product> listprod=query.list();
			sess.close();
			return listprod;
		}
		catch(Exception e){
	
		return null;
		}
	}

	public List<Product> listprodByCategory(int categoryId) {
		try{
			Session sess=sessfact.openSession();
			Query query=sess.createQuery("From Product where categoryId=:catid");
			query.setParameter("catid", categoryId);
			List<Product> listprod=query.list();
			sess.close();
			return listprod;
		}
		catch(Exception e){
	
		return null;
		}
	}
}
