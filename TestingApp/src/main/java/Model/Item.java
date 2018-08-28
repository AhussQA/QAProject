package Model;

import java.util.HashMap;
import java.util.Map;

public class Item {
	private int id=0;
	private String name ="";
	private int categoryID=0;
	private String price ="";
	private int quantity=0;
	private int sellerID=0;
	
	private Map<String,String> itemMap;
	
	public void toHashMap() {
		itemMap = new HashMap<>();
		itemMap.put("id", String.valueOf(id));
		itemMap.put("name", name);
		itemMap.put("id", String.valueOf(categoryID));
	    itemMap.put("price", price);
		itemMap.put("id", String.valueOf(quantity));
		itemMap.put("id", String.valueOf(sellerID));

	}
	
	
	public Map<String, String> getItemMap() {
		return itemMap;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	
	
}
