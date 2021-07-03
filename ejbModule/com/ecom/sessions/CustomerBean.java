package com.ecom.sessions;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecom.dao.CustomerDaoLocal;
import com.ecom.entities.User;

/**
 * Session Bean implementation class CustomerBean
 */
@Stateless
@LocalBean
public class CustomerBean implements CustomerBeanLocal {

	@EJB
    private CustomerDaoLocal customerDaoBean;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    public User createCustomer(String firstName, String lastName, String email, String password, Long phone) {
        User user = new User();
        setCustomerAttribute(user, firstName, lastName, email, password, phone);
        customerDaoBean.persist(user);

        return user;
    }

    public User updateCustomer(Long customerId, String firstName, String lastName, String email, String password, Long phone) {
        User user = customerDaoBean.findCustomerById(customerId);
        setCustomerAttribute(user, firstName, lastName, email, password, phone);
        customerDaoBean.mergeCustomer(user);
        return user;
    }

    public void setCustomerAttribute(User user, String firstName, String lastName, String email, String password,Long phone) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
    }

    public User getCustomerByEmailAndPassword(String mail, String password) {
        User cutomer = customerDaoBean.getCustomerByEmail(mail);
        if (cutomer != null && password.equals(cutomer.getPassword())) {
            return cutomer;
        }
        return null;
    }

}
