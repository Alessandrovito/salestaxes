package org.vitale.services.model;

public class Tax {

	private Category category;
	private float taxApplied; /*10% is equal to 0.1f*/
	private float taxAppliedImported; /*5% is equal to 0.05f*/
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public float getTaxApplied() {
		return taxApplied;
	}
	public void setTaxApplied(float taxApplied) {
		this.taxApplied = taxApplied;
	}
	public float getTaxAppliedImported() {
		return taxAppliedImported;
	}
	public void setTaxAppliedImported(float taxAppliedImported) {
		this.taxAppliedImported = taxAppliedImported;
	}
	@Override
	public String toString() {
		return "Tax [category=" + category + ", taxApplied=" + taxApplied
				+ ", taxAppliedImported=" + taxAppliedImported + "]";
	}
	
	
	
}
