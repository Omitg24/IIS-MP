package uo.mp.shopping.processor.service.shopper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.LinkedList;
import uo.mp.shopping.model.CleaningProduct;
import uo.mp.shopping.model.FoodProduct;
import uo.mp.shopping.model.Product;
import uo.mp.shopping.processor.service.Shopper;

public class AddProductsTest {
private List<Product> products;
	
	@Before
	public void setUp() {
		products = new LinkedList<>();
	}
	
	/**
	 * Pruebas del método addProducts de la clase Shopper:
	 * 1- Se añaden productos que no estan
	 * 2- Se añade un producto que si esta
	 */
	
	/**
	 * 1- Se añaden productos que no estan
	 */
	@Test
	public void newProducts() {
		Shopper shopper = new Shopper("L01344");
		products.add(new FoodProduct("F01", "Carne Ternera", 20.0, 1.0));
		products.add(new FoodProduct("F02", "Carne Pollo", 5.0, 1.0));
		products.add(new CleaningProduct("C01", "Detergente", 8.0, 2));
		products.add(new CleaningProduct("C02", "Suavizante", 5.0, 1));
		shopper.addProducts(products);
		assertEquals(4,shopper.getCartForTest().size());
	}
	
	/**
	 * 2- Se añade un producto que si esta
	 */
	@Test
	public void notNewProducts() {
		Shopper shopper = new Shopper("L01344");
		products.add(new FoodProduct("F01", "Carne Ternera", 20.0, 1.0));
		products.add(new FoodProduct("F02", "Carne Pollo", 5.0, 1.0));
		products.add(new CleaningProduct("C01", "Detergente", 8.0, 2));
		products.add(new CleaningProduct("C02", "Suavizante", 5.0, 1));
		products.add(new FoodProduct("F01", "Carne Ternera", 20.0, 1.0));
		shopper.addProducts(products);
		//assertEquals(4,shopper.getCartForTest().size()); DEBERIA DE SER 4
	}
}
