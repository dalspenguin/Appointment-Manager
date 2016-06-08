package com.thareau.businesslogic;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.thareau.entity.Payment;

/**
 * Session Bean implementation class PaymentSessionBean
 */
@Stateless
@LocalBean
public class PaymentSessionBean implements PaymentSessionBeanRemote {

	
	@PersistenceContext(unitName="payment")
    protected EntityManager em;
	

	@Override
	public Payment createPayment(Payment p) {
		em.persist(p);
		return p;
		
	}


	@Override
	public Payment createPayment(Date d, double a) {
		Payment p =new Payment(d, a); 
		em.persist(p);
		return p;
	}

	
	@Override
	public Payment getPayment(String string) {
		return em.find(Payment.class,string);
	}

	@Override
	public List<Payment> getPayments() {
		return em.createQuery("select object(o) from payments as o").getResultList();
	}


}
