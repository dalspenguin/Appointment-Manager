package com.cbse.client;

import javax.naming.Context;
import javax.naming.NamingException;

import com.cbse.businesslogic.CustomerRegistryBean;
import com.cbse.businesslogic.CustomerRegistryBeanRemote;
import com.cbse.clientutility.ClientUtility;
import com.cbse.entity.Customer;

public class EJBCustomerBeanClient {
	public static void main(String[] args) {
		

		CustomerRegistryBeanRemote bean = doLookup();

		bean.createCustomer();
		bean	.setName("Toto");
		bean	.setStreet("Parisstrasse");
		bean	.setCity("Dresden");
		bean	.setZipCode("01059");
		System.out.println("set");
		Customer c = bean.build();
		
		System.out.println(c);
		
	
    }
 
    private static CustomerRegistryBeanRemote doLookup() {
        Context context = null;
        CustomerRegistryBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = ClientUtility.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName();
            // 3. Lookup and cast
            System.err.println(lookupName);
            bean = (CustomerRegistryBeanRemote) context.lookup(lookupName);
 
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
        String moduleName = "CustomerBean";
 
/*AS7 allows each deployment to have an (optional) distinct name. 
This can be an empty string if distinct name is not specified.
*/
        String distinctName = "";
 
        // The EJB bean implementation class name
        String beanName = CustomerRegistryBean.class.getSimpleName();
 
        // Fully qualified remote interface name
        final String interfaceName = CustomerRegistryBeanRemote.class.getName();
 
        // Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" + 
            distinctName    + "/" + beanName + "!" + interfaceName + "?stateful";
 
        return name;
    }
}
