package org.vitale.services.dao;

import java.util.List;

import org.vitale.services.model.Category;

/**
 * A data access object (DAO) providing persistence and search support for
 * Category entities.
 * 
 * @see org.vitale.services.model.Category
 * @author Alessandro Vitale
 */

public abstract class CategoryDAO {
	
	
	public static final String CAT_FOOD = "food";
	public static final String CAT_MED = "medical";
	public static final String CAT_BOOK = "book";
	public static final String CAT_GENERIC = "generic";
	
	
	public abstract void 			save(Category cat);
	public abstract List<Category>  findAll();
	public abstract Category 		findByName(String Name);
	

}
