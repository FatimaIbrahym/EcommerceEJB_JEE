package com.ecom.dao;

import javax.ejb.Local;

import com.ecom.entities.CartItem;

@Local
public interface CartItemDaoLocal {

    public void persistLineItem(CartItem item);

    public void persist(Object object);
}
