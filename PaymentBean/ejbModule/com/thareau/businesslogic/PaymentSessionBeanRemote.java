package com.thareau.businesslogic;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import com.thareau.entity.Payment;

@Local
public interface PaymentSessionBeanRemote {
	public void createPayment(Payment p);
	public void createPayment(Date d, double a);
	public Payment getPayment(int id);
	public List<Payment> getPayments();
}
