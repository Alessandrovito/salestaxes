package org.vitale.services.model;


public class Item {
	
	String name;
	Category category;
	float price;
	int quantity;
	boolean isImported;
	
	public boolean isImported() {
		return isImported;
	}
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String imp = (isImported) ? "imported" : "";
		return quantity + " " + imp + " " + name + " at " + price ;
	}
	
	public String toStringOutputFinalPrice(float finalPrice) {
		String imp = (isImported) ? "imported" : "";
		return quantity + " " + imp + " " + name + " : " + finalPrice ;
	}
	
	
}
