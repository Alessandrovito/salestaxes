package org.vitale.services.DAO;

import java.util.List;

import org.vitale.services.Model.Category;

/**
 * A data access object (DAO) providing persistence and search support for
 * Category entities.
 * 
 * @see org.vitale.services.Model.Category
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
