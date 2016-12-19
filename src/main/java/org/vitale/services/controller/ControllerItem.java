package org.vitale.services.controller;



import org.vitale.services.DAO.ItemDAO;
import org.vitale.services.DAOImpl.ItemDAOImpl;


/**
 * 
 * Controller to manage Service Item
 * 
 * @author Alessandro Vitale
 *
 */
public class ControllerItem {

	
	private ItemDAO itemDAO = null;
	//private static ControllerItem controllerTax = null;
	
	protected ControllerItem(){
		itemDAO =  new  ItemDAOImpl();
		
	};
	
	public static ControllerItem getControllerItem() {

		return new ControllerItem();
		
	}
	
	public ItemDAO getItemDAO(){
		return itemDAO;
	}
	
	

}
