package uo.mp.s5.dome.model.item;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Cd;
import uo.mp.s5.dome.model.Dvd;
import uo.mp.s5.dome.model.Item;
import uo.mp.s5.dome.model.VideoGame;

/**
 * Titulo: Clase SetTitleTest
 *  
 * @author Omitg
 * @version 26-02-2021
 */
public class SetTitleTest {
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
	 * Pruebas del método setTitle de la clase Item:
	 * 1- Titulo valido
	 * 2- Titulo valido a invalido
	 * 3- Titulo invalido
	 */
	
	/**
	 * 1- Titulo valido
	 * GIVEN Se crean varios items
	 * WHEN Se pone el titulo valido
	 * THEN Se comprueba que el titulo es el correcto
	 */
	@Test
	public void testSetBasePriceValid() {		
		cd.setTitle("Thriller");
		String expected = "Thriller";
		assertEquals(expected, cd.getTitle());
	}
	
	/**
	 * 2- titulo valido a invalido
	 * GIVEN Se crean varios items
	 * WHEN Se pone el titulo valido y posteriormente uno invalido
	 * THEN Se comprueba que el titulo es el correcto
	 */
	@Test
	public void testSetBasePriceValidToInvalid(){
		dvd.setTitle("El ultimo Mohicano");
		dvd.setTitle(null);
		String expected = "El ultimo Mohicano";
		assertEquals(expected, dvd.getTitle());
		
	}
	
	/**
	 * 3- titulo invalido
	 * GIVEN Se crean varios items
	 * WHEN Se pone el titulo invalido
	 * THEN Se comprueba que el titulo es null
	 */
	@Test
	public void testSetBasePriceInvalid() {
		game.setTitle(null);
		String expected = null;
		assertEquals(expected, game.getTitle());
	}
	
}
