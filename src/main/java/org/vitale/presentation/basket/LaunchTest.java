package org.vitale.presentation.basket;

import org.vitale.services.dao.CategoryDAO;

/**
 * 
 * Init class for Sales Tax Exercise
 * 
 * @author Alessandro Vitale
 *
 */
public class LaunchTest {

	public static void main(String[] args) {

		LaunchTest excerciseStart = new LaunchTest();
		excerciseStart.InputOutputTest();

	}
	
	
	public Boolean InputOutputTest(){
		
		ShoppingCart shop1 = new ShoppingCart();
		shop1.addItemInBasket("book", 1, CategoryDAO.CAT_BOOK, false,  12.49f);
		shop1.addItemInBasket("music", 1, CategoryDAO.CAT_GENERIC, false, 14.99f);
		shop1.addItemInBasket("chocolate bar", 1, CategoryDAO.CAT_FOOD, false, 0.85f);

		
		ShoppingCart shop2 = new ShoppingCart();
		shop2.addItemInBasket("box of chocolates",1,  CategoryDAO.CAT_FOOD, true,  10.00f);
		shop2.addItemInBasket("bottle of perfume ",1, CategoryDAO.CAT_GENERIC, true, 47.50f);

		
		ShoppingCart shop3 = new ShoppingCart();
		shop3.addItemInBasket("bottle of perfume ",1, CategoryDAO.CAT_GENERIC, true, 27.99f);
		shop3.addItemInBasket("bottle of perfume ",1, CategoryDAO.CAT_GENERIC, false, 18.99f);
		shop3.addItemInBasket("headache pills", 1, CategoryDAO.CAT_MED, false, 9.75f);
		shop3.addItemInBasket("chocolates", 1, CategoryDAO.CAT_FOOD, true, 11.25f);
		
		
		
		shop1.printInputShoppingCart(1);
		shop2.printInputShoppingCart(2);
		shop3.printInputShoppingCart(3);
		
		
		shop1.printOutputShoppingCart(1);
		shop2.printOutputShoppingCart(2);
		shop3.printOutputShoppingCart(3);
		
		
		return true;
	}

}
