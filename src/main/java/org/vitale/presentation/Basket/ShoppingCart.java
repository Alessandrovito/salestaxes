package org.vitale.presentation.Basket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vitale.services.Model.Item;
import org.vitale.services.ShoppingController.ShoppingController;
import org.vitale.services.controller.ControllerServices;


/**
 * 
 * Shopping Cart
 * 
 * @author Alessandro Vitale
 *
 */

public class ShoppingCart {

	//private ControllerServices cs = new ControllerServices();
	
	private ShoppingController ctr = new ShoppingController();
	

	public boolean addItemInBasket(String nameItem, int cnt,
			String nameCategory, boolean isImported, float price) {

		boolean ret =  ctr.insertItem(nameItem, cnt, nameCategory, isImported, price);
		
		if (ret == false)
			return false;
	
		return true;
		

	}

	public void printOutputShoppingCart(int inputNumber) {

		StringBuilder toPrint = new StringBuilder();

		Iterator<Item> itIter = ctr.findAllItemsInShop().iterator();
		float totalPrice = 0.0f;
		float totalTax = 0.0f;
		float currentAppliedTax = 0.0f;

		toPrint.append("\nINPUT :" + inputNumber);

		while (itIter.hasNext()) {
			Item currentItem = itIter.next();
			currentAppliedTax = ctr.calculateTaxPerItem(currentItem);

			toPrint.append("\n").append(
					currentItem.toStringOutputWithTax(currentAppliedTax));

			totalPrice += currentItem.getPrice();
			totalTax += currentAppliedTax;

		}

		float rem = totalTax % 0.05f;
		if (rem != 0.0f) {
			if (rem > 0.025f)
				totalTax -= rem;
			else
				totalTax += (0.05f - rem);
		}

		toPrint.append("\nSales Tax:" + totalTax);
		toPrint.append("\nTotal :" + totalTax + totalPrice);

		System.out.println(toPrint.toString());

	}

}
