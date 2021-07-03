package com.ecom.sessions;

import javax.ejb.Local;

import com.ecom.entities.Cart;

@Local
public interface OrderBeanLocal {

    public Cart order(Long customerId, CartBeanLocal cartProcessBean);

}
