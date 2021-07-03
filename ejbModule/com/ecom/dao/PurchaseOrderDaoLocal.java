package com.ecom.dao;

import javax.ejb.Local;

import com.ecom.entities.Cart;

@Local
public interface PurchaseOrderDaoLocal {
	
	    public void persist(Object object);

	    public void executeOrder(Cart order);

}
