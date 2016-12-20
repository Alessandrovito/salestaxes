package org.vitale.services.dao.impl;

import org.vitale.services.dao.CategoryDAO;
import org.vitale.services.dao.FactoryDAO;
import org.vitale.services.dao.ItemDAO;
import org.vitale.services.dao.TaxDAO;
/**
 * This is one implemenation of Factory DAO that need to
 * implements method to get concrete Implementation of Category, Item, Tax
 * @author Alessandro Vitale
 *
 */
public class FactoryDAOImpl extends FactoryDAO {

	 public CategoryDAO getCategoryDAO() {
		    //  implements CategoryDAO
	    return new CategoryDAOImpl();
	  }
	  public TaxDAO getTaxDAO() {
		  //  implements TaxDAO
	    return new TaxDAOImpl();
	  }
	  public ItemDAO getItemDAO(){
		  //  implements ItemDAO
	    return new ItemDAOImpl();
	  }
}
