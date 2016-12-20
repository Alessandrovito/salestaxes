package org.vitale.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.vitale.business.controller.ShoppingController;

import org.vitale.services.dao.CategoryDAO;
import org.vitale.services.model.Item;

public class TestDrivenDev {

	private ShoppingController ctr = null;
	
	@Before
	public void setUp() throws Exception {
		ctr = new ShoppingController();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCalculteInput1() {

		Float priceWithTax = 0.0f;
		Float priceWithTaxTotal = 0.0f;
		
		Item book = ctr.insertItem("book", 1, CategoryDAO.CAT_BOOK, false,  12.49f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(book);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(12.49f, priceWithTax, 0.0f);
		
		Item music = ctr.insertItem("music", 1, CategoryDAO.CAT_GENERIC, false, 14.99f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(music);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(16.49f, priceWithTax, 0.0f);
		
		
		Item chocoBar = ctr.insertItem("chocolate bar", 1, CategoryDAO.CAT_FOOD, false, 0.85f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(chocoBar);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(0.85f, priceWithTax, 0.0f);
		
		System.out.println("Total Price  Applied is " + priceWithTaxTotal);
		Assert.assertEquals(29.83f, priceWithTaxTotal, 0.0f);
		
		
	}
	
	
	@Test
	public void testCalculteTotalTaxInput1() {

		Float priceWithTax = 0.0f;
		
	
		priceWithTax += ctr.calculateTaxPerItem(ctr.insertItem("book", 1, CategoryDAO.CAT_BOOK, false,  12.49f));
		System.out.println("Total Applied tax " + priceWithTax);
		
		priceWithTax += ctr.calculateTaxPerItem(ctr.insertItem("music", 1, CategoryDAO.CAT_GENERIC, false, 14.99f));
		System.out.println("Total Applied tax" + priceWithTax);
		
		priceWithTax += ctr.calculateTaxPerItem(ctr.insertItem("chocolate bar", 1, CategoryDAO.CAT_FOOD, false, 0.85f));
		System.out.println("Total Applied tax " + priceWithTax);
		
		

		Assert.assertEquals(1.50f, priceWithTax, 0.0f);
		
	}
	
	
	
	@Test
	public void testCalculteInput2() {

		Float priceWithTax = 0.0f;
		Float priceWithTaxTotal = 0.0f;
		
		Item boxChoc = ctr.insertItem("box of chocolates",1,  CategoryDAO.CAT_FOOD, true,  10.00f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(boxChoc);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(10.50f, priceWithTax, 0.0f);
		
		Item boxParf = ctr.insertItem("bottle of perfume ",1, CategoryDAO.CAT_GENERIC, true, 47.50f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(boxParf);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(54.65f, priceWithTax, 0.0f);
		
		System.out.println("Total Price  Applied is " + priceWithTaxTotal);
		Assert.assertEquals(65.15f, priceWithTaxTotal, 0.0f);
		
		
	}
	
	
	@Test
	public void testCalculteTotalTaxInput2() {

		Float priceWithTax = 0.0f;
		
	
		priceWithTax += ctr.calculateTaxPerItem(ctr.insertItem("box of chocolates",1,  CategoryDAO.CAT_FOOD, true,  10.00f));
		System.out.println("Total Applied tax " + priceWithTax);
		
		priceWithTax += ctr.calculateTaxPerItem(ctr.insertItem("bottle of perfume ",1, CategoryDAO.CAT_GENERIC, true, 47.50f));
		System.out.println("Total Applied tax" + priceWithTax);
			

		Assert.assertEquals(7.65f, priceWithTax, 0.0f);
		
	}
	
	
	@Test
	public void testCalculteInput3() {

		Float priceWithTax = 0.0f;
		Float priceWithTaxTotal = 0.0f;
		
		Item bott1 = ctr.insertItem("bottle of perfume ",1, CategoryDAO.CAT_GENERIC, true, 27.99f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(bott1);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(32.19f, priceWithTax, 0.0f);
		
		Item bott2 = ctr.insertItem("bottle of perfume ",1, CategoryDAO.CAT_GENERIC, false, 18.99f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(bott2);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(20.89f, priceWithTax, 0.0f);
		
		Item pills = ctr.insertItem("headache pills", 1, CategoryDAO.CAT_MED, false, 9.75f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(pills);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(9.75f, priceWithTax, 0.0f);
		
		Item choco = ctr.insertItem("chocolates", 1, CategoryDAO.CAT_FOOD, true, 11.25f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(choco);
		priceWithTaxTotal += priceWithTax;
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(11.85f, priceWithTax, 0.0f);
		
		System.out.println("Total Price  Applied is " + priceWithTaxTotal);
		Assert.assertEquals(74.68f, priceWithTaxTotal, 0.0f);
		
		
	}
	
	
	@Test
	public void testCalcultePriceWithTaxImported() {

		Float priceWithTax = 0.0f;
		
		Item boxChoco = ctr.insertItem("box of chocolates",1,  CategoryDAO.CAT_FOOD, true,  10.00f);
		priceWithTax = ctr.calculatePriceWithTaxPerItem(boxChoco);
		System.out.println("Tax Applied is " + priceWithTax);
		Assert.assertEquals(10.50f, priceWithTax, 0.0f);
		
	}
	
	@After
	public void tearDown() throws Exception {
		ctr = null;
	}
}
