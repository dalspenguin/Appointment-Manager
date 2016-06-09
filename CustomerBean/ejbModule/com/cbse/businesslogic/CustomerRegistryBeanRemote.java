package com.cbse.businesslogic;

import javax.ejb.Remote;

import com.cbse.entity.Address;
import com.cbse.entity.Customer;

@Remote
public interface CustomerRegistryBeanRemote {
	public void createCustomer(String name, Address a);
	public void createCustomer();
	public void setName(String name);
	public void  setStreet(String street);
	public void  setCity(String city);
	public void  setZipCode(String zip);
	public Customer build();
	
	
}
