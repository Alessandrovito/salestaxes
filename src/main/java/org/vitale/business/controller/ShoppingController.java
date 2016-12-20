package org.vitale.business.controller;

import java.math.BigDecimal;
import java.util.List;

import org.vitale.services.dao.CategoryDAO;
import org.vitale.services.dao.FactoryDAO;
import org.vitale.services.dao.ItemDAO;
import org.vitale.services.dao.TaxDAO;

import org.vitale.services.model.Category;
import org.vitale.services.model.Item;
import org.vitale.services.model.Tax;


/**
 * This class is delegated to implements Controller of Shopping System.
 * All logic between Data access and User Presentation  are implemented here.
 *  
 * @author Alessandro Vitale
 *
 */
public class ShoppingController {

	private static final BigDecimal ROUNDVALUE = new BigDecimal("0.05");

	private CategoryDAO categoryDAO = null;
	private TaxDAO taxDAO = null;
	private ItemDAO itemDAO = null;

	public ShoppingController() {
		InitDAO();
		feedingInitDAO();

	}

	public void InitDAO() {

		FactoryDAO saleTestImpl = FactoryDAO.getFactoryDAO();

		categoryDAO = saleTestImpl.getCategoryDAO();
		taxDAO = saleTestImpl.getTaxDAO();
		itemDAO = saleTestImpl.getItemDAO();

	}

	public void feedingInitDAO() {
		InitializationFeedingCategory();
		InitializationFeedingTax();
	}

	private Boolean InitializationFeedingCategory() {

		// Feeding Category: Is possible to use as input feeding XML
		// configuration, file configuration
		// We use simple hard coded values
		categoryDAO.save(new Category(CategoryDAO.CAT_FOOD));
		categoryDAO.save(new Category(CategoryDAO.CAT_MED));
		categoryDAO.save(new Category(CategoryDAO.CAT_BOOK));
		categoryDAO.save(new Category(CategoryDAO.CAT_GENERIC));

		return true;

	}

	private Boolean InitializationFeedingTax() {

		// Feeding Tax: Is possible to use as input feeding XML
		// configuration, file configuration
		// We use simple hard coded values
		Category current = null;

		current = categoryDAO.findByName(CategoryDAO.CAT_BOOK);
		if (current == null)
			return false;
		/* 0.05f meaning 5% */
		taxDAO.save(current, 0, 0.05f);

		current = categoryDAO.findByName(CategoryDAO.CAT_MED);
		if (current == null)
			return false;

		taxDAO.save(current, 0, 0.05f);

		current = categoryDAO.findByName(CategoryDAO.CAT_FOOD);
		if (current == null)
			return false;

		taxDAO.save(current, 0, 0.05f);

		current = categoryDAO.findByName(CategoryDAO.CAT_GENERIC);
		if (current == null)
			return false;

		taxDAO.save(current, 0.1f, 0.05f);

		return true;

	}

	public Item insertItem(String nameItem, int cnt, String nameCategory,
			boolean isImported, float price) {

		Item itemFromShop = new Item();

		Category cat = categoryDAO.findByName(nameCategory);

		if (cat == null)
			return null;

		itemFromShop.setCategory(cat);
		itemFromShop.setName(nameItem);
		itemFromShop.setPrice(price);
		itemFromShop.setQuantity(cnt);
		itemFromShop.setImported(isImported);

		itemDAO.save(itemFromShop);
		return itemFromShop;
	}

	public List<Item> findAllItemsInShop() {
		return itemDAO.findAll();
	}

	public float calculatePriceWithTaxPerItem(Item it) {
		float tax = calculateTaxPerItem(it);
		return tax + it.getPrice();
	}

	public float calculateTaxPerItem(Item it) {

		float totalTaxPer = 0.0f;
		Tax t = taxDAO.findByCategoryName(it.getCategory());
		boolean isImp = it.isImported();
		float taxApplied = 0.0f;
		float price = it.getPrice();
		float taxPerc = t.getTaxApplied();
		float taxImportedPerc = t.getTaxAppliedImported();

		if (taxPerc > 0)
			totalTaxPer += taxPerc;
		if (isImp)
			totalTaxPer += taxImportedPerc;
		
		taxApplied = calculateSalesTax(price, totalTaxPer);
		return taxApplied;

	}

	private float calculateSalesTax(Float price, Float taxPercentage) {
		BigDecimal priceBD = new BigDecimal(Float.toString(price));
		BigDecimal taxPercentageBD = new BigDecimal(
				Float.toString(taxPercentage));
		BigDecimal salesTax = priceBD.multiply(taxPercentageBD);
		salesTax = roundOff(salesTax);
		return salesTax.floatValue();
	}

	private BigDecimal roundOff(BigDecimal value) {
		value = value.divide(ROUNDVALUE);
		value = new BigDecimal(Math.ceil(value.doubleValue()));
		value = value.multiply(ROUNDVALUE);
		return value;
	}

}
