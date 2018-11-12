package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@ComponentScan(basePackages={"edu.osu.cse5234.config" , "edu.osu.cse5234.controller", "edu.osu.cse5234.model"})
@Scope("session")
public class RealEstateController {
	

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homepage(HttpServletRequest request , HttpServletResponse response) {
		return "home";
	}
	
	@RequestMapping(path = "/contactus", method = RequestMethod.GET)
	public String contactus(HttpServletRequest request , HttpServletResponse response) {
		return "contactus";
	}
	
	@RequestMapping(path = "/aboutus", method = RequestMethod.GET)
	public String aboutus(HttpServletRequest request , HttpServletResponse response) {
		return "aboutus";
	}
	
	@RequestMapping(path = "/purchase", method = RequestMethod.GET)
	public String displayItems(HttpServletRequest request , HttpServletResponse response) {
	
		Order order = new Order();
		edu.osu.cse5234.business.view.InventoryServiceBean2Remote inventory = ServiceLocator.getInventoryService();
		List<Item>itemList = inventory.getAvailableInventory().getItems();
		List<LineItem> lineItemList = LineItem.itemToLineItemConverter(itemList);
		
		order.setItemList(lineItemList);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submititem",  method = RequestMethod.POST)
	public String submitItems(@ModelAttribute Order order1, HttpServletRequest request ,
			HttpServletResponse response) {
		
		if(ServiceLocator.getOrderProcessingService().validateItemAvailability(order1)) {
			request.getSession().setAttribute("order", order1);
			return "redirect:/paymententry";
		}
		String error = "Item is unavailable";
		
		request.setAttribute("error", error);
		return "redirect:/cart";
	}
	
	@RequestMapping(path = "/paymententry", method = RequestMethod.GET)
	public String paymentEntry(HttpServletRequest request , HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitpayment",  method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute PaymentInfo paymentInfo, 
			HttpServletRequest request , HttpServletResponse response) {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		Order order = (Order) request.getSession().getAttribute("order");
		order.setPaymentInfo(paymentInfo);
		request.getSession().setAttribute("order", order);
		return "redirect:/shippingentry";
	}
	
	@RequestMapping (path ="/shippingentry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request , HttpServletResponse response) {

		request.setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitshipping",  method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute ShippingInfo shippingInfo,
			HttpServletRequest request , HttpServletResponse response) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		Order order = (Order) request.getSession().getAttribute("order");
		order.setShippingInfo(shippingInfo);
		request.getSession().setAttribute("order", order);
		return "redirect:/vieworder";
	}
	
	@RequestMapping(path = "/vieworder",  method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request , HttpServletResponse responsen) {
		Order order = (Order) request.getSession().getAttribute("order");
		request.setAttribute("order", order);
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmorder",  method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request , HttpServletResponse response) {
		
		
		
		Order order = (Order) request.getSession().getAttribute("order");
		
		String confirmation = ServiceLocator.getOrderProcessingService().processOrder(order);
		
		double total = order.getTotalPrice();
		
		ShippingInfo shippingInfo = (ShippingInfo) request.getSession().getAttribute("shippingInfo");
		
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		request.getSession().setAttribute("total", total);
		request.getSession().setAttribute("confirmationNumber", confirmation);
		return "redirect:/viewconfirmation";
	}
	
	@RequestMapping(path = "/viewconfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request , HttpServletResponse response) {
		return "Confirmation";
	}
}
