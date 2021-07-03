package com.ecom.dao;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ecom.entities.Product;

/**
 * Session Bean implementation class ProductDaoBean
 */
@Stateless
@LocalBean
public class ProductDaoBean implements ProductDaoLocal {

	    @EJB
	    private CategoryDaoLocal categoryDaoBean;
	    @PersistenceContext
	    private EntityManager em;
	    Product product;

	    // Add business logic below. (Right-click in editor and choose
	    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
	    public Product getProductByProductId(Long productId) {
	        return em.find(Product.class, productId);
	    }

		@SuppressWarnings("unchecked")
		public Collection<Product> getProductList() {
	        return  em.createQuery("select p from Product p").getResultList();
	    }

	    public void addProduct(Product product) {
			em.getTransaction().begin();
	        em.persist(product);
			em.getTransaction().commit();
	    }

	@Override
	public void updateProduct(Product product) {
		Product pr =em.find(Product.class, product.getId());
		em.getTransaction().begin();
		pr.setAvailability(product.isAvailability());
		pr.setDescription(product.getDescription());
		pr.setPrice(product.getPrice());
		pr.setQuantity(product.getQuantity());
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	/*	public Collection<Product> getProductListByCategoryId(Long catgoryId) {
	        return (Collection<Product>) em.createNamedQuery("Product.findByCategoryId").setParameter("catgoryId", catgoryId).getResultList();
	    }*/

	@Override
	public void deleteProduct(Long id) {
	    Product pr =em.find(Product.class, id);
		em.getTransaction().begin();
		em.remove(pr);
		em.getTransaction().commit();

	}

	public void persist(Object object) {
	        em.persist(object);
	    }

}
