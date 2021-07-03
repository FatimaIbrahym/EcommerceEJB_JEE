package com.ecom.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.ecom.entities.Category;

@Local
public interface CategoryDaoLocal {

	public void persist(Object object);

    public void deleteAll();

    public Collection<Category> getCategoryList();

    public Category getCategoryByName(String categoryName);

    public Category addCategory(String name);

    public void createCategory();
}
