package com.cbse.businesslogic;

import java.util.Date;
import java.util.List;


import javax.ejb.Remote;

import com.cbse.entity.Payment;

@Remote
public interface PaymentSessionBeanRemote {
	public Payment createPayment(Payment p);
	public Payment createPayment(Date d, double a);
	public Payment getPayment(String id);
	public List<Payment> getPayments();
}
