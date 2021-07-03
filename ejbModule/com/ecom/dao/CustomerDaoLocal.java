package com.ecom.dao;

import javax.ejb.Local;

import com.ecom.entities.User;

@Local
public interface CustomerDaoLocal {

	public User findCustomerById(Long customerId);

    public User getCustomerByEmail(String mail);

    public void mergeCustomer(User user);
    
    public void persist(Object object);
    User addUser(User user);
}
