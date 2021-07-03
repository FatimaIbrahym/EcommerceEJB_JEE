package com.ecom.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ecom.entities.Cart;

/**
 * Session Bean implementation class PurchaseOrederBean
 */
@Stateless
@LocalBean
public class PurchaseOrderDaoBean implements PurchaseOrderDaoRemote, PurchaseOrderDaoLocal {

	    @PersistenceContext
	    private EntityManager em;

	    public void persist(Object object) {
	        em.persist(object);
	    }

	    // Add business logic below. (Right-click in editor and choose
	    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
	    
	    public void executeOrder(Cart order) {
	        em.persist(order);
	    }
}
