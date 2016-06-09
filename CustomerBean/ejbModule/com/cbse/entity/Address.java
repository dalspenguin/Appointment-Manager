package com.cbse.entity;

import java.io.Serializable;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.Produces;


/**
 * Created by dmitr on 6/7/2016.
 */

@Produces
@Entity
@Table(name="adresses")
public class Address implements Serializable{
    // Data type
    
    @Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2050921138453714326L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private String id;


	@Basic
	@Column(name="street")
    private String street;
	@Basic
	@Column(name="city")
    private String city;
	@Basic
	@Column(name="zip_code")
        private String zipCode;

	public Address(String street, String city, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public Address(){
		
	}

	public String getId() {
		return id;
	}

	
	public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
