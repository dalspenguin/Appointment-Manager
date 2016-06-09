package com.cbse;

import java.util.List;

/**
 * Created by dmitr on 6/7/2016.
 */
public class Shipment {

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private ShipmentState shipmentState;
    private Address address;
    private List<Product> products;
}
