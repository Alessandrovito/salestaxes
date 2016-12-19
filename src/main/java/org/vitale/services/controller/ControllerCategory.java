package org.vitale.services.controller;

import org.vitale.services.DAO.CategoryDAO;
import org.vitale.services.DAOImpl.CategoryDAOImpl;
import org.vitale.services.Model.Category;


/**
 * 
 * Controller to manage Service Category
 * 
 * @author Alessandro Vitale
 *
 */

public class ControllerCategory {
	
	private static CategoryDAO categoryDAO = null;
	private static ControllerCategory controllerCategory = null;
	
	protected ControllerCategory(){
		categoryDAO =  new  CategoryDAOImpl();
		InitializationFeedingCategory();
	};
	
	public static ControllerCategory getControllerCategory() {
		if (controllerCategory == null)
			controllerCategory = new ControllerCategory();

		return controllerCategory;
	}
	
	public CategoryDAO getCategoryDAO(){
		
		return categoryDAO;
	}

	
	private Boolean InitializationFeedingCategory(){
		
		//Feeding Category: Is possible to use as input feeding XML configuration, file configuration
		// We use simple hard coded values
		categoryDAO.save(new Category(CategoryDAO.CAT_FOOD));
		categoryDAO.save(new Category(CategoryDAO.CAT_MED));
		categoryDAO.save(new Category(CategoryDAO.CAT_BOOK));
		categoryDAO.save(new Category(CategoryDAO.CAT_GENERIC));
		
		return true;
		
		
	}
	
	
}
