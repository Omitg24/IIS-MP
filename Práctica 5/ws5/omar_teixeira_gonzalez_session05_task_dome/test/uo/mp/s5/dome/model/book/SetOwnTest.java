package uo.mp.s5.dome.model.book;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Book;

/**
 * Titulo: Clase SetOwnTest
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class SetOwnTest {
	/**
	 * Atributo libro
	 */
	private Book book;
	
	/**
	 * Atributo theTittle, titulo del libro
	 */
	private String theTitle;
	/**
	 * Atributo theAuthor, autor del libro
	 */
	private String theAuthor;
	/**
	 * Atributo theEditorial, editorial del libro
	 */
	private String theEditorial;
	/**
	 * Atributo theIsbn, isbn del libro
	 */
	private String theIsbn;
	
	/**
	 * Atributo basePrice, precio base
	 */
	private double basePrice;
		
	/**
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "Daredevil Born Again";
		theAuthor = "Frank Miller & David Mazzucchelli";
		theEditorial = "Marvel Comics";
		theIsbn = "978-8498854756";
		basePrice= 22.95;
		book = new Book(theTitle, theAuthor, theEditorial, theIsbn, basePrice);
	}
	
	/**
	 * Pruebas del método setOwn de la clase Book:
	 * 1- Se pasa true dos veces
	 * 2- Se pasa true y posteriormente se pasa false
	 * 3- Se pasa false dos veces
	 * 4- Se pasa false y posteriormente se pasa true 
	 */
	
	/**
	 * 1- Se pasa true dos veces
	 * GIVEN libro con valor true para propietario 
	 * WHEN se invoca setOwn con true
	 * THEN el libro permanece con true en propietario 
	 */
	@Test
	public void trueToTrue() {
		book.setOwn(true);
		book.setOwn(true);
		assertEquals(true, book.getOwn());
	}

	/**
	 * 2- Se pasa true y posteriormente se pasa false
	 * GIVEN libro con valor true para propietario 
	 * WHEN se invoca setOwn con false
	 * THEN el libro cambia a false en propietario 
	 */
	@Test
	public void trueToFalse() {
		book.setOwn(true);
		book.setOwn(false);
		assertEquals(false, book.getOwn());
	}

	/**
	 * 3- Se pasa false dos veces
	 * GIVEN libro con valor false para propietario 
	 * WHEN se invoca setOwn con false
	 * THEN el libro permanece con false en propietario 
	 */
	@Test
	public void falseToFalse() {
		book.setOwn(false);
		book.setOwn(false);
		assertEquals(false, book.getOwn());
	}

	/**
	 * 4- Se pasa false y posteriormente se pasa true
	 * GIVEN libro con valor false para propietario 
	 * WHEN se invoca setOwn con true
	 * THEN el libro cambia a true en propietario
	 */
	@Test
	public void falseToTrue() {
		book.setOwn(false);
		book.setOwn(true);
		assertEquals(true, book.getOwn());
	}
}
