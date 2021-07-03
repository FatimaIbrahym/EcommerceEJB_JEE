package com.ecom.dao;

import com.ecom.entities.Cart;
import com.ecom.entities.CartItem;

import javax.ejb.Local;

@Local
public interface CartDaoLocal {
    void emptyCart(Long id);
    void addToCart(Long userId,CartItem cartItem);
    void deleteCartItem(Long cartItemId);
    Boolean  updateCartIem(Long cartItemId ,int quantity);
}
