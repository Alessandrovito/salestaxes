package org.vitale.test;



import org.vitale.presentation.Basket.ShoppingCart;
import org.vitale.services.DAO.CategoryDAO;
import org.vitale.services.Model.Item;
import org.vitale.services.ShoppingController.ShoppingController;

public class TestDrivenDev {



	
	private ShoppingController ctr = null;
	
	@Before
	public void setUp() throws Exception {
		ctr = new ShoppingController();
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCalcultePriceWithTax() {

		Item book = ctr.insertItem("book", 1, CategoryDAO.CAT_BOOK, false,  12.49f);
		
		assertEquals(10, ctr.calculatePriceWithTaxPerItem(book));
		
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		ctr = null;
	}
}
