package com.cbse.client;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.NamingException;

import com.cbse.businesslogic.CustomerRegistryBean;
import com.cbse.businesslogic.CustomerRegistryBeanRemote;
import com.cbse.businesslogic.PaymentSessionBean;
import com.cbse.businesslogic.PaymentSessionBeanRemote;
import com.cbse.clientutility.ClientUtility;
import com.cbse.entity.Customer;
import com.cbse.entity.Payment;

public class EJBPaymentBeanClient {
	public static void main(String[] args) {
		

		PaymentSessionBeanRemote paymentBean = doLookupPayment();
		
		SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

		String strdate2 = "01-11-2013 12:00:00";
		Date d = null;
		try {
			d = dateformat2.parse(strdate2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Payment p = paymentBean.createPayment(d, 253.6);
		Payment p1 = paymentBean.getPayment(p.getId());
		System.out.println(p);
//		System.out.println(p1);

		System.out.println("banane");
//
//		CustomerRegistryBeanRemote customerBean = doLookupCustomer();
//		customerBean.createCustomer();
//		customerBean.createCustomer();
//		customerBean.setName("paymentBeanTest");
//		customerBean.setStreet("Parisstrasse");
//		customerBean.setCity("Dresden");
//		customerBean.setZipCode("01059");
//		Customer c = customerBean.build();
//		p = paymentBean.createPayment(d, 128.2, c);
//		System.out.println(p);
	}
	
	private static CustomerRegistryBeanRemote doLookupCustomer() {
        Context context = null;
        CustomerRegistryBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = ClientUtility.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName("Customer");
            // 3. Lookup and cast
            bean = (CustomerRegistryBeanRemote) context.lookup(lookupName);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }

 
    private static PaymentSessionBeanRemote doLookupPayment() {
        Context context = null;
        PaymentSessionBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = ClientUtility.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName("Payment");
            // 3. Lookup and cast
            bean = (PaymentSessionBeanRemote) context.lookup(lookupName);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
 
    private static String getLookupName(String kind) {
/* 
The app name is the EAR name of the deployed EJB without .ear suffix. 
Since we haven't deployed the application as a .ear, 
the app name for us will be an empty string
*/
        String appName = "";
 
        /* The module name is the JAR name of the deployed EJB 
        without the .jar suffix.
        */
        String moduleName;
        if(kind.equals("Payment"))
        	moduleName = "PaymentBean";
        else 
        	moduleName = "CustomerBean";
 
/*AS7 allows each deployment to have an (optional) distinct name. 
This can be an empty string if distinct name is not specified.
*/
        String distinctName = "";
 
        // The EJB bean implementation class name
        String beanName ;
        if(kind.equals("Payment"))
        	beanName = PaymentSessionBean.class.getSimpleName();
        else
        	beanName = CustomerRegistryBean.class.getSimpleName();
        // Fully qualified remote interface name
        final String interfaceName;
        if(kind.equals("Payment"))
        	interfaceName = PaymentSessionBeanRemote.class.getName();
        else
        	interfaceName = CustomerRegistryBeanRemote.class.getSimpleName();
 
        // Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" + 
            distinctName    + "/" + beanName + "!" + interfaceName;
 
        return name;
    }
}
