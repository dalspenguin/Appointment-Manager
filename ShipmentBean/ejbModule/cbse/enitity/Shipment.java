package com.cbse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitr on 6/7/2016.
 */
public class Shipment {

	public Shipment()
	{
		products = new ArrayList<Product>();
	}
	
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public void addProduct(Product product)
    {
    	this.products.add(product);
    }

    public ShipmentState getShipmentState()
    {
    	return shipmentState;
    }
    
    public void setId(int newId)
    {
    	id = newId;
    }
    
    public int getId()
    {
    	return id;
    }
    
    private int id;
    private ShipmentState shipmentState;
    private Address address;
    private List<Product> products;
}
