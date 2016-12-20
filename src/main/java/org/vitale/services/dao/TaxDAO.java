package org.vitale.services.dao;


import org.vitale.services.model.Category;
import org.vitale.services.model.Tax;

public abstract class TaxDAO {
	

	public abstract void save(Category cat, float tax, float taxImported);
	public abstract Tax findByCategoryName(Category cat);
	

}
