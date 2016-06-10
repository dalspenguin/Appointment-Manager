package com.ibytecode.business;
import com.cbse.Product;
import com.cbse.ShipmentState;

import javax.ejb.Remote;

@Remote
public interface ShipmentComponent {
	public ShipmentState getShipmentState(int id) throws Exception;
	public void addProduct(Product product, int id) throws Exception;
	public int createNewShipment() throws Exception;
}
