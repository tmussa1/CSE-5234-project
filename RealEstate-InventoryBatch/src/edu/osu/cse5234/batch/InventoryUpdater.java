package edu.osu.cse5234.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class InventoryUpdater {

	public static void main(String[] args) {
		System.out.println("Start Inventory Update......");
		try {	
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
			updateInventory(orderedItems, conn);
			updateOrderStatus(newOrderIds, conn);
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	private static void updateOrderStatus(Collection<Integer> newOrderIds, Connection conn) {
		try {
			
			for(Integer id : newOrderIds) {
				
				conn.createStatement().execute("update customer_order set status = 'processed' where id=" + id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void updateInventory(Map<Integer, Integer> orderedItems, Connection conn) {
		try {
			
			for(Integer key : orderedItems.keySet()) {
				
				ResultSet rst = conn.createStatement().executeQuery("select id, available_quantity from item where item_number =" + key);
				
				while(rst.next()) {
					int temp = rst.getInt("available_quantity") - orderedItems.get(key);
					int item_id_temp = rst.getInt("ID");
					conn.createStatement().execute("update item set available_quantity =" + temp + "where id=" + item_id_temp);
				
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds, Connection conn) throws SQLException {
		Map<Integer, Integer> lineItems = new HashMap<>();
		
		for(Integer id: newOrderIds) {
			ResultSet rst = conn.createStatement().executeQuery("select ITEM_ID, quantity "
					+ "from CUSTOMER_ORDER_LINE_ITEM where CUSTOMER_ORDER_ID_FK =" + id);
			while(rst.next()) {
				
				if(lineItems.containsKey(rst.getInt("ITEM_ID"))) {				
					int temp = lineItems.get(rst.getInt("ITEM_ID"));		
					lineItems.put(rst.getInt("ITEM_ID"), rst.getInt("quantity") + temp);
				} else {
					lineItems.put(rst.getInt("ITEM_ID"), rst.getInt("quantity"));
				}
				
			}
		}
		return lineItems;
	}

	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rst = conn.createStatement().executeQuery("select ID from CUSTOMER_ORDER where STATUS = 'New' ");
		
		while(rst.next()) {
			orderIds.add(new Integer(rst.getInt("ID")));
		}
		return orderIds;
	}

	private static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/RealEstateDB", "sa", "");
		return conn;
	}

}

