package com.cbse.businesslogic;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cbse.entity.Address;
import com.cbse.entity.Customer;

/**
 * Session Bean implementation class CustomerRegistryBean
 */
@Stateful
public class CustomerRegistryBean implements CustomerRegistryBeanRemote {


	@PersistenceContext(unitName="customer")
	protected EntityManager em;

	private String name;
	private String street;
	private String zip;
	private String city;
	/**
	 * Default constructor. 
	 */
	public CustomerRegistryBean() {
	}

	@Override
	public void createCustomer(String name, Address a) {
		em.persist(new Customer(name,a));

	}

	@Override
	public void createCustomer() {
	}

	@Override
	public void setName(String name) {
		this.name =name;	 
	}

	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public void setZipCode(String zip) {
		this.zip = zip;
	}

	@Override
	public Customer build() {
		Customer c = new Customer(name, new Address(street,city,zip));
		em.persist(c);
		return c;
	}

}
