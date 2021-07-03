package com.ecom.sessions;

import javax.ejb.Local;

import com.ecom.entities.Product;

@Local
public interface ProductBeanLocal {

	 public void updateProductQuantity(Long id, int quantity);

	 public void createProduct();
	 public void createProduct(Product product);
	 public void updateProduct(Product product);
	 public void deleteProduct(Long id);

}
