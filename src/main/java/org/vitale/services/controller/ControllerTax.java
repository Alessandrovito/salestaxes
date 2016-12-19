package org.vitale.services.controller;


import org.vitale.services.DAO.CategoryDAO;
import org.vitale.services.DAO.TaxDAO;
import org.vitale.services.DAOImpl.TaxDAOImpl;
import org.vitale.services.Model.Category;
/**
 * 
 * Controller to manage Service Tax
 * 
 * @author Alessandro Vitale
 *
 */

public class ControllerTax {

	
	private static TaxDAO taxDAO = null;
	private static ControllerTax controllerTax = null;
	
	protected ControllerTax(){
		taxDAO =  new TaxDAOImpl();
		InitializationFeedingTax();
		
	};
	
	public static ControllerTax getControllerTax() {
		if (controllerTax == null)
			controllerTax = new ControllerTax();
		
	
		return controllerTax;
	}
	
	public TaxDAO getTaxDAO(){
		return taxDAO;
	}
	
	public Boolean InitializationFeedingTax(){
			
			//Feeding 
			Category current = null;
			
			CategoryDAO categoryDAO = ControllerCategory.getControllerCategory().getCategoryDAO();
			
			current = categoryDAO.findByName(CategoryDAO.CAT_BOOK);
			if (current== null)
				return false;
			/*0.05f meaning 5%*/
			taxDAO.save(current, 0, 0.05f);
			
			current = categoryDAO.findByName(CategoryDAO.CAT_MED);
			if (current== null)
				return false;
			
			taxDAO.save(current, 0, 0.05f);
			
			current = categoryDAO.findByName(CategoryDAO.CAT_FOOD);
			if (current== null)
				return false;
			
			taxDAO.save(current, 0, 0.05f);
			
			
			current = categoryDAO.findByName(CategoryDAO.CAT_GENERIC);
			if (current== null)
				return false;
			
			taxDAO.save(current, 0.1f, 0.05f);
			
			return true;
	
			
			
		}

}
