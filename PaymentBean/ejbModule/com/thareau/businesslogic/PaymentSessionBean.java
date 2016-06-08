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
	public void createPayment(Payment p) {
		em.persist(p);
		
	}


	@Override
	public void createPayment(Date d, double a) {
		em.persist(new Payment(d, a));
	}

	
	@Override
	public Payment getPayment(int id) {
		return em.find(Payment.class,id);
	}

	@Override
	public List<Payment> getPayments() {
		return em.createQuery("select object(o) from payments as o").getResultList();
	}


}
