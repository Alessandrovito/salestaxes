package org.vitale.services.dao;

import org.vitale.services.dao.impl.FactoryDAOImpl;


/**
 * This is a Factory for DAO . This class create implementation of Factory DAO
 * This simpe exaple create only one type of FactoryDAO (FactoryDAOImpl)
 * @author Ale-Dell
 *
 */
public abstract class FactoryDAO {
	

  public abstract CategoryDAO getCategoryDAO();
  public abstract TaxDAO getTaxDAO();
  public abstract ItemDAO getItemDAO();


  public static FactoryDAO getFactoryDAO() {

	     /*Simple Factory DAO implements only one concrete class FactoryDAOImpl*/
          return new FactoryDAOImpl();


  }


}
