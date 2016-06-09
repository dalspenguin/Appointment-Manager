package com.cbse;

/**
 * Created by dmitr on 6/8/2016.
 */
public class Order {
    private Process process;
    private Shipment shipment;
    private Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
