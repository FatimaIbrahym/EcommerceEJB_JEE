package com.ecom.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ecom.entities.CartItem;

/**
 * Session Bean implementation class LineItemDaoBean
 */
@Stateless
@LocalBean
public class CartItemDaoBean implements CartItemDaoLocal {

	 @PersistenceContext
	    private EntityManager em;
	    public void persistLineItem(CartItem item) {
	        em.persist(item);
	    }

	    public void persist(Object object) {
	        em.persist(object);
	    }
	    // Add business logic below. (Right-click in editor and choose
	    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
}
