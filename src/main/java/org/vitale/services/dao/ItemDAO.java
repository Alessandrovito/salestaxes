package org.vitale.services.DAO;

import java.util.List;


import org.vitale.services.Model.Item;

public abstract class ItemDAO {
	
	
	public abstract void 		save(Item it);
	public abstract List<Item>  findAll();
	public abstract Item 		findByName(String Name);
}
