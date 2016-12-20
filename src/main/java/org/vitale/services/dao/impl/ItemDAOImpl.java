package org.vitale.services.DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vitale.services.DAO.ItemDAO;
import org.vitale.services.Model.Category;
import org.vitale.services.Model.Item;
/**
 * Implementation DAO is simple and Data are stored in List collection
 * 
 * @author Alessandro Vitale
 *
 */
public class ItemDAOImpl extends  ItemDAO {
	
	List<Item> items = new ArrayList<Item>();
	
	public void save(Item it) {
		
		items.add(it);
		return;
	}
	

	
	public List<Item> findAll(){
		
		return items;
	}
	
	public Item findByName(String name) {
		
		Iterator<Item> itIter = items.iterator();
	    while (itIter.hasNext())
	    {
	    	Item currentItem = itIter.next();
	    	if (currentItem.getName().equalsIgnoreCase(name))
	    		return currentItem;
		
	    }
		
		return null;
	}

}
