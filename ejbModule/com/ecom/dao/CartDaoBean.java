package com.ecom.dao;

import com.ecom.entities.Cart;
import com.ecom.entities.CartItem;
import com.ecom.entities.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class CartDaoBean implements CartDaoLocal {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void emptyCart(Long id) {
    Cart cart = em.find(Cart.class,id);
    em.getTransaction().begin();
    cart.getCartItems().clear();
    em.persist(cart);
    em.getTransaction().commit();
    }

    @Override
    public void addToCart(Long userId,CartItem cartItem) {
        User user = em.find(User.class,userId);

    }

    @Override
    public void deleteCartItem(Long cartItemId) {
        CartItem item = em.find(CartItem.class,cartItemId);
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }

    @Override
    public Boolean updateCartIem(Long cartItemId, int quantity) {
        CartItem item = em.find(CartItem.class,cartItemId);
        em.getTransaction().begin();
        if(item !=null && item.getProduct().getQuantity() >= quantity && quantity>0){
            item.setQuantity(quantity);
            em.persist(item);
            return true;
        }else if(item != null && quantity == 0){
            em.remove(item);
            return true;
        }
        return false;
    }
}
