package org.vitale.services.DAO;


import org.vitale.services.Model.Category;
import org.vitale.services.Model.Tax;

public abstract class TaxDAO {
	

	public abstract void save(Category cat, float tax, float taxImported);
	public abstract Tax findByCategoryName(Category cat);
	

}
