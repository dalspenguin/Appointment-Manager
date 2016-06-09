package com.cbse.client;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.NamingException;

import com.cbse.businesslogic.PaymentSessionBean;
import com.cbse.businesslogic.PaymentSessionBeanRemote;
import com.cbse.clientutility.ClientUtility;
import com.cbse.entity.Payment;

public class EJBPaymentBeanClient {
	public static void main(String[] args) {
		

		PaymentSessionBeanRemote bean = doLookup();
		
		SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

		String strdate2 = "01-11-2013 12:00:00";
		Date d = null;
		try {
			d = dateformat2.parse(strdate2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Payment p = bean.createPayment(d, 253.6);
		Payment p1 = bean.getPayment(p.getId());
		System.out.println(p);
		System.out.println(p1);
		
    }
 
    private static PaymentSessionBeanRemote doLookup() {
        Context context = null;
        PaymentSessionBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = ClientUtility.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName();
            // 3. Lookup and cast
            System.err.println(lookupName);
            bean = (PaymentSessionBeanRemote) context.lookup(lookupName);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
 
    private static String getLookupName() {
/* 
The app name is the EAR name of the deployed EJB without .ear suffix. 
Since we haven't deployed the application as a .ear, 
the app name for us will be an empty string
*/
        String appName = "";
 
        /* The module name is the JAR name of the deployed EJB 
        without the .jar suffix.
        */
        String moduleName = "PaymentBean";
 
/*AS7 allows each deployment to have an (optional) distinct name. 
This can be an empty string if distinct name is not specified.
*/
        String distinctName = "";
 
        // The EJB bean implementation class name
        String beanName = PaymentSessionBean.class.getSimpleName();
 
        // Fully qualified remote interface name
        final String interfaceName = PaymentSessionBeanRemote.class.getName();
 
        // Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" + 
            distinctName    + "/" + beanName + "!" + interfaceName;
 
        return name;
    }
}
