package org.vitale.presentation.Basket;

import java.util.Iterator;
import org.vitale.services.Model.Item;
import org.vitale.services.controller.ControllerServices;


/**
 * 
 * Shopping Cart
 * 
 * @author Alessandro Vitale
 *
 */

public class ShoppingCart {

	private ControllerServices cs = new ControllerServices();

	public boolean addItemInBasket(String nameItem, int cnt,
			String nameCategory, boolean isImported, float price) {

		return cs.insertItem(nameItem, cnt, nameCategory, isImported, price);

	}

	public void printOutputShoppingCart(int inputNumber) {

		StringBuilder toPrint = new StringBuilder();

		Iterator<Item> itIter = cs.findAllItemsInShop().iterator();
		float totalPrice = 0.0f;
		float totalTax = 0.0f;
		float currentAppliedTax = 0.0f;

		toPrint.append("\nINPUT :" + inputNumber);

		while (itIter.hasNext()) {
			Item currentItem = itIter.next();
			currentAppliedTax = cs.calculateTaxPerItem(currentItem);

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
