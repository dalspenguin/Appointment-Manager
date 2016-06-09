package com.cbse.businesslogic;

import javax.ejb.Remote;

import com.cbse.entity.Address;
import com.cbse.entity.Customer;

@Remote
public interface CustomerRegistryBeanRemote {
	public void createCustomer(String name, Address a);
	public CustomerRegistryBeanRemote createUser();
	public CustomerRegistryBeanRemote setName(String name);
	public CustomerRegistryBeanRemote setStreet(String street);
	public CustomerRegistryBeanRemote setCity(String city);
	public CustomerRegistryBeanRemote setZipCode(String zip);
	public Customer build();
	
	
}
