package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
public class InventoryServiceBean implements InventoryService {

	@PersistenceContext
	EntityManager entityManager;
	
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public static String MY_QUERY = "Select i from Item i";
    
	@Override
	public Inventory getAvailableInventory() {
		Inventory inventory = new Inventory();
		inventory.setItems(entityManager.createQuery(MY_QUERY, Item.class).getResultList());
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		List<Item> inventory = getAvailableInventory().getItems();
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getQuantity() > inventory.get(i).getQuantity())
				return false;
		}
		
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		return true;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	

}
