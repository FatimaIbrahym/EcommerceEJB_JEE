package com.ecom.dao;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ecom.entities.Category;
import com.ecom.enumerations.CategoryEnum;

/**
 * Session Bean implementation class CategoryDaoBean
 */
@Stateless
@LocalBean
public class CategoryDaoBean implements CategoryDaoRemote, CategoryDaoLocal {

	@EJB
    private ProductDaoLocal productDaoBean;
    @PersistenceContext
    private EntityManager em;
    Category category;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    public void deleteAll() {
        for (Iterator<?> it = getCategoryList().iterator(); it.hasNext();) {
            Object object = it.next();
            em.remove(object);

        }
        for (Iterator<?> it = productDaoBean.getProductList().iterator(); it.hasNext();) {
            Object object = it.next();
            em.remove(object);
        }
    }

    @SuppressWarnings("unchecked")
	public Collection<Category> getCategoryList() {
        return (Collection<Category>) em.createNamedQuery("Category.findAll").getResultList();
    }

    public Category getCategoryByName(String categoryName) {
        return (Category) em.createNamedQuery("Category.findByCategoryName").setParameter("categoryName", categoryName).getSingleResult();
    }

    public Category addCategory(String name) {
        category = new Category();
        category.setName(name);
        em.persist(category);
        return category;
    }

    public void createCategory() {
        addCategory(CategoryEnum.Men.getCategoryText());
        addCategory(CategoryEnum.Women.getCategoryText());
        addCategory(CategoryEnum.Kid.getCategoryText());
    }
    
}
