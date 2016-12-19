package org.vitale.services.controller;



import java.util.List;

import org.vitale.services.DAO.*;
import org.vitale.services.Model.Category;
import org.vitale.services.Model.Item;
import org.vitale.services.Model.Tax;

/**
 * 
 * Main Controller to manage all Services (Category, Item, Tax)
 * 
 * @author Alessandro Vitale
 *
 */

public class ControllerServices {
	
	private static final float round=0.05f;
	
	private  CategoryDAO categoryDAO = null;
	private  TaxDAO taxDAO = null;
	private  ItemDAO itemDAO = null;
	
	
	public ControllerServices(){
		InitDAO();
	}
	
	public void InitDAO(){
		// Implementation dipendent : we could  use dependency injection to astract this
		// More important sequence: First create Category, second TaxDao after 

	    categoryDAO = ControllerCategory.getControllerCategory().getCategoryDAO();
		taxDAO = ControllerTax.getControllerTax().getTaxDAO();
		itemDAO = ControllerItem.getControllerItem().getItemDAO();

	}
	
	
	

	public Boolean insertItem(String nameItem, int cnt, String nameCategory, boolean isImported, float price){
		
		Item itemFromShop = new Item();
		
		
		Category cat = categoryDAO.findByName(nameCategory);
		
		if (cat == null)
				return false;
		
		itemFromShop.setCategory(cat);
		itemFromShop.setName(nameItem);
		itemFromShop.setPrice(price);
		itemFromShop.setQuantity(cnt);
		
		itemDAO.save(itemFromShop);
		return true;
		
	}
	
	public List<Item> findAllItemsInShop(){
		
		return itemDAO.findAll();
		
	}
	
	
	public float calculatePriceWithTaxPerItem(Item it){
		float tax = calculateTaxPerItem(it);
		return tax + it.getPrice();
	}

	
	public float calculateTaxPerItem(Item it){

		float totalTaxPer = 0.0f;
		Tax t = taxDAO.findByCategoryName(it.getCategory());
		
		boolean isImp = it.isImported();
		float taxApplied;
		float price = it.getPrice();
		
		float taxPerc= t.getTaxApplied();
		float taxImportedPerc= t.getTaxAppliedImported();
		
		if (taxPerc > 0)
			totalTaxPer += taxPerc;
		if (isImp)
			totalTaxPer += taxImportedPerc;
		
		
		taxApplied =  price * totalTaxPer;
		
		return taxApplied;
		
		
	}
	
	
	
	
	
	

}
