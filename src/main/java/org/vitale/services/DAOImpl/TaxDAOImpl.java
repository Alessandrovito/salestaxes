package org.vitale.services.DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vitale.services.DAO.CategoryDAO;
import org.vitale.services.DAO.TaxDAO;
import org.vitale.services.Model.Category;
import org.vitale.services.Model.Tax;


/**
 * Impleentaion DAO is simple and Data are stored in List collection
 * 
 * @author Alessandro Vitale
 *
 */
public class TaxDAOImpl extends TaxDAO {
	
	
	private List<Tax> taxes = null;
	
	public TaxDAOImpl(){
		/*Load all configuration*/
		taxes = new ArrayList<Tax>();
		
	}
	
	
	public void save(Category cat, float tax, float taxImported){
		
		Tax taxInsert = new Tax();
		taxInsert.setCategory(cat);
		taxInsert.setTaxApplied(tax);
		taxInsert.setTaxAppliedImported(taxImported);
		taxes.add(taxInsert);
		
	}
	
	public Tax findByCategoryName(Category cat){
		
		Iterator<Tax> taxIter = taxes.iterator();
	    while (taxIter.hasNext())
	    {
	    	Tax currentItem = taxIter.next();
	    	if (currentItem.getCategory().getName().equalsIgnoreCase(cat.getName()))
	    		return currentItem;
		
	    }
		
		return null;
		
	}

}
