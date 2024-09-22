package uo.mp.newsstand;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.service.Newsstand;

/**
 * Titulo: Clase CreateOrdersTest
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class CreateOrdersTest {
	/**
	 * Atributo kiosko
	 */
	private Newsstand ns;
	
	/**
	 * Creaci�n de objetos para su posterior uso
	 */
	@Before
	public void setUp() {
		ns = new Newsstand();
	}
	
	/**
	 * Pruebas del m�todo createOrders de la clase Newsstand:
	 * 1- Con periodico
	 * 2- Con revista
	 */
	
	/**
	 * 1- Con periodico
	 * GIVEN Se crea un kiosko, se a�aden publicaciones
	 * WHEN Se llama al m�todo create orders
	 * THEN Se comprueba que los objetos creados son los mismos
	 */
	@Test
	public void newspaperTest() {
		int SALES =  15;
		int STOCK = 1;
		ns.addPublication(new Newspaper("Hola", STOCK, SALES));
		Order expected = new Order("Hola", SALES+2);
		
		ns.createOrders();
		
		Order order = ns.getOrders().get(0);
		assertTrue(expected.toString().equals(order.toString()));
	}	
	
	/**
	 * 2- Con revista
	 * GIVEN Se crea un kiosko, se a�aden publicaciones
	 * WHEN Se llama al m�todo create orders
	 * THEN Se comprueba que los objetos creados son los mismos
	 */
	@Test
	public void magazineTest() {
		int SALES =  15;
		int STOCK = Magazine.MIN_STOCK+1;
		int PERIOD = Magazine.WEEKLY;
		ns.addPublication(new Magazine("Hola", STOCK, SALES, PERIOD));
		Order expected = new Order("Hola", SALES);
		
		ns.createOrders();
		
		Order order = ns.getOrders().get(0);
		assertTrue(expected.toString().equals(order.toString()));
	}	
}
