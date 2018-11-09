package edu.osu.cse5234.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.osu.cse5234.business.view.Item;

@Entity
@Table(name="CUSTOMER_ORDER_LINE_ITEM")
public class LineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LINE_ITEM_ID")
	private int id;
	
	@Column(name="ITEM_ID")
	private int itemNumber;
	
	@Column(name="item_name")
	private String itemName;
	
	@Transient
	private double price;
	
	@Column(name="quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LineItem() {
	}

	public LineItem(int id, int itemNumber, String itemName, double price, int quantity) {
		super();
		this.id = id;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public static List<LineItem> itemToLineItemConverter (List<Item> itemList) {
		List<LineItem> lineItemList = new ArrayList<>();
		
		for(Item item: itemList) {
			lineItemList.add(new LineItem(item.getId(), item.getItemNumber(), item.getItemName(), item.getPrice(), item.getQuantity()));
		}
		
		return lineItemList;
		
	}
	
	public static List<Item> lineItemToItemConverter (List<LineItem> lineItemList) {
		
		

		
		List<Item> itemList = new ArrayList<>();
		
		for(LineItem item: lineItemList) {
			itemList.add(new Item(item.getId(), item.getItemNumber(), item.getItemName(), item.getPrice(), item.getQuantity()));
		}
		

		//lineItemList.forEach(item -> itemList.add(lambdaFun(item)));
		
		return itemList;
		
	}

//	private static Item lambdaFun(LineItem item) {
//		return new Item(item.getId(), item.getItemNumber(), item.getItemName(), item.getPrice(), item.getQuantity());
//	}
	
	
}
