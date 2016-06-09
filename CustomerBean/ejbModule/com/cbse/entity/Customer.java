package com.cbse.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.Produces;
/**
 * Created by dmitr on 6/8/2016.
 */


@Produces
@Entity
@Table(name="customers")
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


	@OneToMany(mappedBy = "customer_id", fetch = FetchType.LAZY)
    private List<Payment> payments;

	//@Basic
	//@Column(name="street")
	//private List<Order> orders;

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

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
		payments = new ArrayList<Payment>();
	}

	public Customer() {
		super();
		this.name = "";
		this.address = new Address();
		this.approved = false;
		payments = new ArrayList<Payment>();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", approved=" + approved + ", address=" + address + "]";
	}
//
//	public static void main(String[] args) {
//		Address a = new Address("t", "e", "est");
//		Customer c = new Customer("lambda",a);
//		ObjectOutputStream oos = null;
//		try {
//			final FileOutputStream fichier = new FileOutputStream("Customer.ser");
//			oos = new ObjectOutputStream(fichier);
//			oos.writeObject(c);
//			oos.flush();
//		} catch (final java.io.IOException e) {
//			e.printStackTrace();
//
//		} finally {
//			try {
//				if (oos != null) {
//					oos.flush();
//					oos.close();
//				}
//			} catch (final IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//		ObjectInputStream ois = null;
//
//		System.out.println(c);
//		
//		try {
//			final FileInputStream fichier = new FileInputStream("Customer.ser");
//			ois = new ObjectInputStream(fichier);
//			final Customer personne = (Customer) ois.readObject();
//			System.out.println(personne);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
}
