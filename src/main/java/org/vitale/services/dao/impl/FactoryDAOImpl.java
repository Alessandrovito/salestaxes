package org.vitale.services.DAOImpl;

import org.vitale.services.DAO.CategoryDAO;
import org.vitale.services.DAO.FactoryDAO;
import org.vitale.services.DAO.ItemDAO;
import org.vitale.services.DAO.TaxDAO;

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
