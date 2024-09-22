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

public class CalculateCostTest {
	
	private List<Product> products;
	
	@Before
	public void setUp() {
		products = new LinkedList<>();
	}
	
	/**
	 * Pruebas del método calculateCost de la clase Shopper:
	 * 1- Nada en la lista
	 * 2- Productos en la lista con descuento
	 * 3- Productos en la lista sin descuento
	 */
	
	/**
	 * 1- Nada en la lista
	 */
	@Test
	public void emptyCart() {
		Shopper shopper = new Shopper("S01344");
		assertEquals(0.0,shopper.calculateCost(),0.1);
	}
	
	/**
	 * 2- Productos en la lista con descuento
	 */
	@Test
	public void productsWithDiscount() {
		Shopper shopper = new Shopper("L01344");
		products.add(new FoodProduct("F01", "Carne Ternera", 20.0, 1.0));
		products.add(new FoodProduct("F02", "Carne Pollo", 5.0, 1.0));
		products.add(new CleaningProduct("C01", "Detergente", 8.0, 2));
		products.add(new CleaningProduct("C02", "Suavizante", 5.0, 1));
		shopper.addProducts(products);
		assertEquals(51.119, shopper.calculateCost(), 0.1);
	}
	
	/**
	 * 3- Productos en la lista sin descuento
	 */
	@Test
	public void productsWithoutDiscount() {
		Shopper shopper = new Shopper("S01344");
		products.add(new FoodProduct("F01", "Carne Ternera", 20.0, 1.0));
		products.add(new FoodProduct("F02", "Carne Pollo", 5.0, 1.0));
		products.add(new CleaningProduct("C01", "Detergente", 8.0, 2));
		products.add(new CleaningProduct("C02", "Suavizante", 5.0, 1));
		shopper.addProducts(products);
		assertEquals(52.7, shopper.calculateCost(), 0.1);
	}
}
