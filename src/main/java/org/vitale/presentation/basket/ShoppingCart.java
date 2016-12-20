package org.vitale.presentation.basket;


import java.util.Iterator;
import org.vitale.business.controller.ShoppingController;
import org.vitale.services.model.Item;


/**
 * 
 * Shopping Cart to provide for all INPUTs
 * 
 * @author Alessandro Vitale
 *
 */

public class ShoppingCart {

	private ShoppingController ctr = new ShoppingController();
	

	public Item addItemInBasket(String nameItem, int cnt,
			String nameCategory, boolean isImported, float price) {

		Item it =  ctr.insertItem(nameItem, cnt, nameCategory, isImported, price);
		
		if (it == null)
			return null;
	
		return it;
		

	}

	public void printOutputShoppingCart(int inputNumber) {

		StringBuilder toPrint = new StringBuilder();

		Iterator<Item> itIter = ctr.findAllItemsInShop().iterator();
		float totalPrice, totalTax, currentAppliedTax, currentPrice, currentPriceWithTax;
		totalPrice = totalTax = currentAppliedTax =  currentPrice = currentPriceWithTax = 0.0f;

		toPrint.append("\nOUTPUT " + inputNumber + ":");

		while (itIter.hasNext()) {
			Item currentItem = itIter.next();
			currentAppliedTax = ctr.calculateTaxPerItem(currentItem);
			currentPrice = currentItem.getPrice();
			currentPriceWithTax = currentAppliedTax + currentPrice;
			toPrint.append("\n").append(
					currentItem.toStringOutputFinalPrice(currentPriceWithTax));

			totalPrice += currentPriceWithTax;
			totalTax += currentAppliedTax;

		}

		toPrint.append("\nSales Tax:" + totalTax);
		toPrint.append("\nTotal :" + totalPrice);

		System.out.println(toPrint.toString());

	}
	
	public void printInputShoppingCart(int inputNumber) {

		StringBuilder toPrint = new StringBuilder();
		Iterator<Item> itIter = ctr.findAllItemsInShop().iterator();

		toPrint.append("\nINPUT " + inputNumber + ":");

		while (itIter.hasNext()) {
			Item currentItem = itIter.next();
			toPrint.append("\n").append(
					currentItem.toString());
		}

		System.out.println(toPrint.toString());

	}
	
	

}
