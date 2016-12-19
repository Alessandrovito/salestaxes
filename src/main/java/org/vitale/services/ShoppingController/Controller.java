package org.vitale.services.ShoppingController;

import org.vitale.services.DAO.CategoryDAO;
import org.vitale.services.DAO.ItemDAO;
import org.vitale.services.DAO.TaxDAO;
import org.vitale.services.DAOImpl.CategoryDAOImpl;
import org.vitale.services.DAOImpl.ItemDAOImpl;
import org.vitale.services.DAOImpl.TaxDAOImpl;
import org.vitale.services.controller.ControllerCategory;

public class Controller {
	
private static final float round=0.05f;
	
	private  CategoryDAO categoryDAO = null;
	private  TaxDAO taxDAO = null;
	private  ItemDAO itemDAO = null;

	private static Controller controller;
	
	protected Controller(){
		categoryDAO =  new  CategoryDAOImpl();
		InitializationFeedingCategory();
		
		taxDAO =  new TaxDAOImpl();
		InitializationFeedingTax();
		
		itemDAO =  new  ItemDAOImpl();
		
	}
	
	public static Controller getController() {
		if (controller == null)
			controller = new Controller();

		return controller;
	}
	
	
	
}
