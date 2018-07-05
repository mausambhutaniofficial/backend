package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Supplier;
@Repository("suppDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
@Autowired
SessionFactory sessfact;
	public boolean addSupplier(Supplier supplier) {
		System.out.println("we are in add supplier method");
		try{
			sessfact.getCurrentSession().save(supplier);
			System.out.println("successfully added the category");
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try{
			sessfact.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}
	public boolean deleteSupplier(Supplier supplier) {
		try{
			sessfact.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	public Supplier getSupplier(int suppId) {
		try{
			System.out.println("we are in get supplier methd");
			Session sess=sessfact.getCurrentSession();
			Supplier supplier=(Supplier)sess.get(Supplier.class, suppId);
			
			return supplier;
		}
		
		catch(Exception e){
		
			return null;
		}
	}

	public List<Supplier> listsupplier() {
		try{
			Session sess=sessfact.getCurrentSession();
			Query query=sess.createQuery("From Supplier");
			List<Supplier> listsupplier=query.list();
			return listsupplier;
		}
		catch(Exception e){
	
		return null;
		}
	}


	

	

	
}
