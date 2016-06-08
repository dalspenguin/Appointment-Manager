/**
 * 
 */
package com.thareau.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.Produces;

@Produces
@Entity
@Table(name="payments")
public class Payment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3834505342075442954L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private String id;

	@Basic
	@Column(name="p_date")
    private Date date;
	
	@Basic
	@Column(name="amount")
    private double amount;
	


	@Override
	public String toString() {
		return "Payment [id=" + id + ", date=" + date + ", amount=" + amount + "]";
	}


	public Payment(Date date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	
	public Payment(){
		super();
		
	}


	public String getId() {
		return id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
