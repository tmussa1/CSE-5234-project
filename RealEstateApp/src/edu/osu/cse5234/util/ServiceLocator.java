package edu.osu.cse5234.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.InventoryServiceBean2Remote;

public class ServiceLocator {

	public static OrderProcessingServiceBean getOrderProcessingService() 
	{
		try 
		{
			return (OrderProcessingServiceBean) InitialContext.doLookup("java:module/OrderProcessingServiceBean!"
					+ "edu.osu.cse5234.business.OrderProcessingServiceBean");
			} catch (NamingException ne) {
				throw new RuntimeException(ne);
			}
	}
	
	public static InventoryServiceBean2Remote getInventoryService() { 
		try 
		{
			return (InventoryServiceBean2Remote) InitialContext.doLookup("java:global/RealEstate-InventoryManagementEAR/RealEstate-InventoryManagement"
					+ "/InventoryServiceBean2!"
					+ "edu.osu.cse5234.business.view.InventoryServiceBean2Remote");
			} catch (NamingException ne) {
				throw new RuntimeException(ne);
			}
		
	}
	
}
