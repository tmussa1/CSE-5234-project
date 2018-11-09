package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="ITEM")
public class Item implements Serializable{

	private static final long serialVersionUID = -6085040579203132797L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int  id;
	
	
	@Column(name="ITEM_NUMBER")
	private int itemNumber;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name=" NAME")
	private String itemName;
	
	@Column(name="UNIT_PRICE")
	private double price;
	
	
	@Column(name="AVAILABLE_QUANTITY")
	private int quantity;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Item(String itemName, double price) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = 0;
	}
	public Item() {
	}
	public Item(int id, int itemNumber, String itemName, double price, int quantity) {
		super();
		this.id = id;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
}
