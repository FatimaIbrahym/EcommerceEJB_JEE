package com.ecom.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.ecom.entities.Cart;
import com.ecom.entities.User;

/**
 * Session Bean implementation class CustomerDaoBean
 */
@Stateless
@LocalBean
public class CustomerDaoBean implements CustomerDaoLocal {

	@PersistenceContext
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    public User findCustomerById(Long customerId) {
        return em.find(User.class,customerId);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public User addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        Cart cart = new Cart();
        em.persist(cart);
        cart.setCustomer(user);
        user.setCart(cart); em.getTransaction().commit();
        return user;
    }

    public User getCustomerByEmail(String email) {
        User user = null;
        try {
          //  user = (User) em.createNamedQuery("Customer.findByCustomerMail").setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Ce client n'existe pas.");
        }
        return user;
    }

    public void mergeCustomer(User user) {
        em.merge(user);
    }

}
