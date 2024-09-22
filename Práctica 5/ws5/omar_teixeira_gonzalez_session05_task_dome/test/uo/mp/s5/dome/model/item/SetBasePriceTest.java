package uo.mp.s5.dome.model.item;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Cd;
import uo.mp.s5.dome.model.Dvd;
import uo.mp.s5.dome.model.Item;
import uo.mp.s5.dome.model.VideoGame;

/**
 * Titulo: Clase SetBasePriceTest
 *  
 * @author Omitg
 * @version 26-02-2021
 */
public class SetBasePriceTest {
	/**
	 * Atributo item
	 */
	private Item cd, dvd, game;
	
	/**
	 * Creación de objetos para su posterior uso
	 */
	@Before
	public void setUp() {
		cd = new Cd();
		dvd = new Dvd();
		game = new VideoGame();
	}
	/**
	 * Pruebas del método setBasePrice de la clase Item:
	 * 1- Precio valido
	 * 2- Precio valido a invalido
	 * 3- Precio invalido
	 */
	
	/**
	 * 1- Precio valido
	 * GIVEN Se crean varios items
	 * WHEN Se pone el precio base valido
	 * THEN Se comprueba que el precio base es el correcto
	 */
	@Test
	public void testSetBasePriceValid() {		
		cd.setBasePrice(18.99);
		double expected = 18.99;
		assertEquals(expected, cd.getBasePrice(), 0.1);
	}
	
	/**
	 * 2- Precio valido a invalido
	 * GIVEN Se crean varios items
	 * WHEN Se pone el precio base valido y posteriormente uno invalido
	 * THEN Se comprueba que el precio base es el correcto
	 */
	@Test
	public void testSetBasePriceValidToInvalid(){
		dvd.setBasePrice(29.99);
		dvd.setBasePrice(-2.99);
		double expected = 29.99;
		assertEquals(expected, dvd.getBasePrice(),0.1);
		
	}
	
	/**
	 * 3- Precio invalido
	 * GIVEN Se crean varios items
	 * WHEN Se pone el precio base invalido
	 * THEN Se comprueba que el precio base es 0.0
	 */
	@Test
	public void testSetBasePriceInvalid() {
		game.setBasePrice(-100.0);
		double expected = 0.0;
		assertEquals(expected, game.getBasePrice(),0.1);
	}
	
}
