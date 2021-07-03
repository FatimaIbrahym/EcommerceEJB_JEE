package com.ecom.sessions;

import javax.ejb.Local;

import com.ecom.entities.User;

@Local
public interface CustomerBeanLocal {
	
	 public User createCustomer(String firstName, String lastName, String email, String password, String billingAddress, String shipingAddress, int billingZipCode, int shipingZipCode, String billingCity, String shipingCity, Long phone);

	 public User updateCustomer(Long customerId, String firstName, String lastName, String email, String password, String billingAddress, String shippingAddress, int billingZipCode, int shippingZipCode, String billingCity, String shippingCity, Long phone);

	 public User getCustomerByEmailAndPassword(String mail, String password);

}
