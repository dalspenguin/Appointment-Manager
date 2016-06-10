package com.ibytecode.businesslogic;

import com.ibytecode.business.ShipmentComponent;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.cbse.ShipmentState;
import com.cbse.Product;
import com.cbse.Shipment;

/**
 * Session Bean implementation class AppManagerBean
 */
@Stateless
@LocalBean
public class ShipmentComponentBean implements ShipmentComponent {

	private List<Shipment> shipments; 
	/**
	 * Default constructor.
	 */
	public ShipmentComponentBean() {
		shipments = new ArrayList<Shipment>();
	}
	
	public int createNewShipment() throws Exception
	{
		Shipment shipment = new Shipment();
		shipment.setId(shipments.size());
		shipments.add(shipment);
		return shipment.getId();
	}
	
	public ShipmentState getShipmentState(int id) throws Exception {
		Shipment shipment = getShipment(id);
		return shipment.getShipmentState();
	}
	
    public void addProduct(Product product, int id) throws Exception
    {
		Shipment shipment = getShipment(id);
    	shipment.addProduct(product);
    }
    
    private Shipment getShipment(int id) throws Exception
    {
    	for(Shipment shipment : shipments)
    	{
    		int shipmentId = shipment.getId(); 
    		if (shipmentId == id)
    			return shipment;
    	}
		throw new Exception("Cannot find shipment id=" + id); 
    }
}
