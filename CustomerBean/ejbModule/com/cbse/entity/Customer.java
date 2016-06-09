package com.cbse.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.ws.rs.Produces;
/**
 * Created by dmitr on 6/8/2016.
 */
public class Customer implements Serializable{
    //  Data type

    /**
	 * 
	 */
	private static final long serialVersionUID = 7640712649964793106L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Basic
	@Column(name="name")
	private String name;
	@Basic
	@Column(name="approved")
    private Boolean approved;
	
	@OneToOne(fetch = FetchType.LAZY,cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name = "adresses", referencedColumnName = "id", insertable = false, updatable = false)
    private Address address;
	
	
	//private List<Payment> payments;
	
	//@Basic
	//@Column(name="street")
    //private List<Order> orders;

 /*   public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
*/
    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Payment> getPayments() {
//        return payments;
//    }
//
//    public void setPayments(List<Payment> payments) {
//        this.payments = payments;
//    }
    
    
    
    
    public Customer(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
		approved =false;
		
	}

	public Customer() {
		super();
		this.name = "";
		this.address = new Address();
		this.approved = false;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", approved=" + approved + ", address=" + address + "]";
	}
}
