package org.vitale.services.DAO;

import org.vitale.services.DAOImpl.FactoryDAOImpl;

public abstract class FactoryDAO {
	

  public abstract CategoryDAO getCategoryDAO();
  public abstract TaxDAO getTaxDAO();
  public abstract ItemDAO getItemDAO();


  public static FactoryDAO getFactoryDAO() {

	     /*Simple Factory DAO implements only one concrete class FactoryDAOImpl*/
          return new FactoryDAOImpl();


  }


}
