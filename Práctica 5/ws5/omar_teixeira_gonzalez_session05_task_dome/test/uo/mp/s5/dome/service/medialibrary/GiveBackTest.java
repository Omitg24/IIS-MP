package uo.mp.s5.dome.service.medialibrary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Book;
import uo.mp.s5.dome.model.Cd;
import uo.mp.s5.dome.service.MediaLibrary;

/**
 * Titulo: Clase GiveBackTest
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class GiveBackTest {
	/**
	 * Atributos cd
	 */
	private Cd cd1, cd2, cd3;
		
	/**
	 * Atributos libro
	 */
	private Book book1, book2, book3;
	
	private MediaLibrary lib;
	
	/**
	 * Creación de atributos para su posterior uso
	 */
	@Before
	public void setUp() {
		lib = new MediaLibrary();
		cd1 = new Cd("TIM", "Avicii", 12, 38, 19.99, true);
		cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 
				28, 146, 39.99, true); 
		cd3 = new Cd("Meteora (Bonus Edition)", "Linkin Park", 16, 46, 14.99, true);		
		book1 = new Book("The Truth about the Harry Quebert Affair","Joël Dicker",
				"DEBOLSILLO", "978-8466332286", 10.95, true);
		book2 = new Book("The Fall of the Giants","Ken Follet", "DEBOLSILLO",
				"978-8499899800", 10.95, true);
		book3 = new Book("Batman The Killing Joke","Alan Moore & Brian Azzarello",
				"DC Comics", "978-0930289454", 19.95, true);		
		lib.add(cd1);
		lib.add(cd2);
		lib.add(cd3);
		lib.add(book1);
		lib.add(book2);
		lib.add(book3);
	}
	
	/**
	 * Pruebas del método borrow de la clase MediaLibrary:
	 * 1- Ninguno a devolver en la lista
	 * 2- Uno a devolver en la lista 
	 * 3- Varios a devolver en la lista
	 * 4- Todos a devolver en la lista
	 */
	
	/**
	 * 1- Ninguno a devolver en la lista
	 * GIVEN Se crean varios objetos
	 * WHEN Se llama al método giveBack con un objeto no posible
	 * THEN Se comprueba que devuelve false
	 */
	@Test
	public void testNoneToGiveBack() {
		assertFalse(lib.giveBack(book1));
	}
	
	/**
	 * 2- Uno a devolver en la lista 
	 * GIVEN Se crean varios objetos
	 * WHEN Se llama al método giveBack con un objeto posible
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void testOneToGiveBack() {
		book1.setOwn(false);
		assertTrue(lib.giveBack(book1));
	}
	
	/**
	 * 3- Varios a devolver en la lista
	 * GIVEN Se crean varios objetos
	 * WHEN Se llama al método giveBack con objetos posible
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void testSomeToGiveBack() {
		book1.setOwn(false);
		cd1.setOwn(false);
		book2.setOwn(false);
		assertTrue(lib.giveBack(book1));
		assertTrue(lib.giveBack(cd1));
		assertTrue(lib.giveBack(book2));
	}
	
	/**
	 * 4- Todos a devolver en la lista
	 * GIVEN Se crean varios objetos
	 * WHEN Se llama al método giveBack con todos los objeto posibles
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void testAllToGiveBack() {
		book1.setOwn(false);
		cd1.setOwn(false);
		book2.setOwn(false);
		cd2.setOwn(false);
		book3.setOwn(false);
		cd3.setOwn(false);		
		assertTrue(lib.giveBack(book1));
		assertTrue(lib.giveBack(cd1));
		assertTrue(lib.giveBack(book2));
		assertTrue(lib.giveBack(cd2));
		assertTrue(lib.giveBack(cd3));
		assertTrue(lib.giveBack(book3));
	}
}