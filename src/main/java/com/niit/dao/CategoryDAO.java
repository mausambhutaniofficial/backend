package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO {

	public boolean addCategory(Category categ);
	public boolean updateCategory(Category categ);
	public boolean deleteCategory(Category categ);
	
	public Category getCategory(int categoryId);
	public List<Category> listcateg();
	       
}