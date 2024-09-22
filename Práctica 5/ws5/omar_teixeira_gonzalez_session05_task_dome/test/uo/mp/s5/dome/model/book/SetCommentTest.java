package uo.mp.s5.dome.model.book;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Book;

/**
 * Titulo: Clase SetCommentTest
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class SetCommentTest {
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
	 * Pruebas del método setComment de la clase Book:
	 * 1- Se escribe el comentario correctamente
	 * 2- Se escribe null y posteriormente el comentario correcto 
	 */
	
	/**
	 * 1- Se escribe el comentario correctamente
	 * GIVEN libro con comentario vacío 
	 * WHEN invoca setComment con cadena no vacía como comentario 
	 * THEN se cambia el comentario a la cadena 
	 */
	@Test
	public void setComment() {
		book.setComment("Excellent");

		assertEquals("Excellent", book.getComment());
	}

	/**
	 * 2- Se escribe null y posteriormente el comentario correcto
	 * GIVEN libro con comentario no vacío
	 * WHEN invoca setComment con null 
	 * THEN permanece el comentario que había
	 */
	@Test
	public void setInvalidComment() {
		book.setComment("Excellent");
		book.setComment(null);

		assertEquals("Excellent", book.getComment());
	}
}
