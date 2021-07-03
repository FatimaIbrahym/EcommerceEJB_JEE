package com.ecom.dao;

import javax.ejb.Local;

import com.ecom.entities.Product;

@Local
public interface ProductDaoLocal {

	    public Product getProductByProductId(java.lang.Long productId);

	    public void persist(Object object);

	    public java.util.Collection<Product> getProductList();

	    public void addProduct(Product product);
	    public void updateProduct(Product product);

	  //  public java.util.Collection<Product> getProductListByCategoryId(java.lang.Long catgoryId);
	    public void deleteProduct(Long id);
}
