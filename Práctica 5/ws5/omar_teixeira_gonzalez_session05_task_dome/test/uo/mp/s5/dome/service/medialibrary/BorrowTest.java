package uo.mp.s5.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Book;
import uo.mp.s5.dome.model.Cd;
import uo.mp.s5.dome.service.MediaLibrary;

/**
 * Titulo: BorrowTest
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class BorrowTest {
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
		cd1 = new Cd("TIM", "Avicii", 12, 38, 19.99);
		cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 
				28, 146, 39.99); 
		cd3 = new Cd("Meteora (Bonus Edition)", "Linkin Park", 16, 46, 14.99);		
		book1 = new Book("The Truth about the Harry Quebert Affair","Joël Dicker",
				"DEBOLSILLO", "978-8466332286", 10.95);
		book2 = new Book("The Fall of the Giants","Ken Follet", "DEBOLSILLO",
				"978-8499899800", 10.95);
		book3 = new Book("Batman The Killing Joke","Alan Moore & Brian Azzarello",
				"DC Comics", "978-0930289454", 19.95);
		lib.add(cd1);
		lib.add(cd2);
		lib.add(cd3);
		lib.add(book1);
		lib.add(book2);
		lib.add(book3);
	}
	
	/**
	 * Pruebas del método borrow de la clase MediaLibrary:
	 * 1- Ninguno prestable en la lista
	 * 2- Uno prestable en la lista 
	 * 3- Varios prestables en la lista
	 * 4- Todos prestables en la lista
	 */
	
	/**
	 * 1- Ninguno prestable en la lista
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se llama al método borrow
	 * THEN Se comprueba que devuelve null
	 */
	@Test
	public void testNoneInTheList() {
		assertNull(lib.borrow(book1));
	}
	
	/**
	 * 2- Uno prestable en la lista
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se llama al método borrow con un objeto
	 * THEN Se comprueba que devuelve el objeto
	 */
	@Test
	public void testOneInTheList() {
		book1.setOwn(true);
		assertEquals(book1,lib.borrow(book1));		
	}	
	
	/**
	 * 3- Varios prestables en la lista
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se llama al método borrow con varios objetos
	 * THEN Se comprueba que devuelve los objetos
	 */
	@Test
	public void testSomeInTheList() {
		book1.setOwn(true);
		cd1.setOwn(true);
		book2.setOwn(true);
		assertEquals(book1,lib.borrow(book1));
		assertEquals(cd1,lib.borrow(cd1));
		assertEquals(book2,lib.borrow(book2));
	}
	
	/**
	 * 4- Todos prestables en la lista
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se llama al método borrow con todos los objetos
	 * THEN Se comprueba que devuelve todos los objetos
	 */
	@Test
	public void testAllInTheList() {
		book1.setOwn(true);
		cd1.setOwn(true);
		book2.setOwn(true);
		cd2.setOwn(true);
		book3.setOwn(true);
		cd3.setOwn(true);
		assertEquals(book1,lib.borrow(book1));
		assertEquals(cd1,lib.borrow(cd1));
		assertEquals(book2,lib.borrow(book2));
		assertEquals(cd2,lib.borrow(cd2));
		assertEquals(book3,lib.borrow(book3));
		assertEquals(cd3,lib.borrow(cd3));
	}	
}
