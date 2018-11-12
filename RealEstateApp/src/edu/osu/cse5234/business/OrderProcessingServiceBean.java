package edu.osu.cse5234.business;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ups.shipping.client.ShippingInitiationClient;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
@Resource(name = "jms/emailQCF", lookup = "jms/emailQCF", type = ConnectionFactory.class)
public class OrderProcessingServiceBean {

	
	private static String shippingResourceURI = "http://localhost:9081/UPS/jaxrs";
	
	@PersistenceContext
	EntityManager entityManager;

	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;

	@Resource(lookup = "jms/emailQ")
	private Queue queue;

	public OrderProcessingServiceBean() {
		// TODO Auto-generated constructor stub
	}

	public String processOrder(Order order) {
		InventoryService inventory = ServiceLocator.getInventoryService();
		List<Item> itemList = converter(order);

		if (inventory.validateQuantity(itemList)) {
			inventory.updateInventory(itemList);
			entityManager.persist(order);
			entityManager.flush();
			notifyUser();
		}
		
		JsonObject shipJson = Json.createObjectBuilder()
								.add("Organization", "Flintstone Homes")
								.add("OrderRefId", "E35961")
								.add("Zip", "43213")
								.add("ItemsNumber", 6)
								.build();
		
		ShippingInitiationClient shipClient = new ShippingInitiationClient(shippingResourceURI);
		JsonObject confirmJson = shipClient.invokeInitiateShipping(shipJson);
		
		boolean accepted = confirmJson.getBoolean("Accepted");
		int shippingReference = confirmJson.getInt("ShippingReferenceNumber");
		
		if(accepted) {
			System.out.println("Shipping reference number is " + shippingReference);
		}
		

		return "E35961" + new Random().nextInt(1000);
	}

	private List<Item> converter(Order order) {
		if (order != null) {
			List<LineItem> lineItemList = order.getItemList();
			List<Item> itemList = LineItem.lineItemToItemConverter(lineItemList);
			return itemList;
		}
		return null;
	}

	public boolean validateItemAvailability(Order order) {

		List<Item> itemList = converter(order);
		return ServiceLocator.getInventoryService().validateQuantity(itemList);
	}

	private void notifyUser() {
		String message = "wzdsmxy@gmail.com" + ":" + "Your order was successfully submitted. "
				+ "You will hear from us when items are shipped. " + new Date();
		System.out.println("Sending message: " + message);
		jmsContext.createProducer().send(queue, message);
		System.out.println("Message Sent!");
	}
}
