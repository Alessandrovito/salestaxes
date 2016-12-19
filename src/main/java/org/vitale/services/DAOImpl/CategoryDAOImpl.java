package org.vitale.services.DAOImpl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vitale.services.DAO.CategoryDAO;
import org.vitale.services.Model.Category;



/**
 * Implementation DAO is simple and Data are stored in List collection
 * 
 * @author Alessandro Vitale
 *
 */

public class CategoryDAOImpl extends CategoryDAO {

	// list is working as database
	private final List<Category> categories;
	
	
	public CategoryDAOImpl(){
		
		categories = new ArrayList<Category>();

	}
	
	
	public void save(Category cat){
		categories.add(cat);
		
	}
	
	public List<Category> findAll(){
		return categories;
		
	}
	
	public Category findByName(String name){
		
		Iterator<Category> catIter = categories.iterator();
	    while (catIter.hasNext())
	    {
	    	Category currentItem = catIter.next();
	    	if (currentItem.getName().equalsIgnoreCase(name))
	    		return currentItem;
		
	    }
		
		return null;
		
	}


	
}
