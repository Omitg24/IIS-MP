package uo.mp.s5.dome.model.book;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Book;

/**
 * Titulo: Clase BookTest
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class BookTest {
	/**
	 * Atributo theTittle, titulo del CD
	 */
	private String theTitle;
	/**
	 * Atributo theArtist, artista del CD
	 */
	private String theAuthor;
	/**
	 * Atributo theTIme, tiempo de duraci�n del CD
	 */
	private String theEditorial;
	/**
	 * Atributo theTracks, numero de pistas que hay en el CD
	 */
	private String theIsbn;
	
	/**
	 * Atributo basePrice, precio base
	 */
	private double basePrice;
		
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "Daredevil Born Again";
		theAuthor = "Frank Miller & David Mazzucchelli";
		theEditorial = "Marvel Comics";
		theIsbn = "978-8498854756";
		basePrice= 22.95;
	}
	
	/**
	 * Pruebas del constructor con par�metros de la clase Cd:
	 * Pruebas de funcionalidad:
	 * 1- Par�metros validos -> Se crea el objeto
	 * 
	 * Pruebas de robustez:
	 * 2- Titulo invalido -> Se lanza la excepci�n
	 * 3- Autor invalido -> Se lanza la excepci�n
	 * 4- Editorial invalida -> Se lanza la excepci�n
	 * 5- ISBN invalido -> Se lanza la excepci�n
	 * 6- Precio invalido -> Se lanza la excepci�n
	 */
	
	//Pruebas de funcionamiento:
		/**
		 * 1- Par�metros validos -> Se crea el objeto
		 * GIVEN
		 * WHEN Se crea con par�metros v�lidos 
		 * THEN: se crea y los valores se asignan a los atributos
		 */
		@Test
		public void testConstructorValidParams() {
			Book book = new Book(theTitle, theAuthor, theEditorial, theIsbn, basePrice);

			assertEquals("Daredevil Born Again", book.getTitle());
			assertEquals("Frank Miller & David Mazzucchelli", book.getAuthor());
			assertEquals("Marvel Comics", book.getEditorial());
			assertEquals("978-8498854756", book.getIsbn());			
			assertEquals(basePrice, book.getBasePrice(), 0.1);
		}
	//Pruebas de robustez:
		/**
		 * 2- Titulo invalido -> Se lanza la excepci�n
		 * GIVEN
		 * WHEN Se crea con par�metro titulo null 
		 * THEN Se lanza la excepci�n
		 */
		@Test(expected = IllegalArgumentException.class)
		public void testConstructorInvalidTittle() {
			new Book(null, theAuthor, theEditorial, theIsbn, basePrice);
		}

		/**
		 * 3- Artista invalido -> Se lanza la excepci�n
		 * GIVEN
		 * WHEN Se crea con par�metro artista null 
		 * THEN Se lanza la excepci�n
		 */
		@Test(expected = IllegalArgumentException.class)
		public void testConstructorInvalidArtis() {
			new Book(theTitle, null, theEditorial, theIsbn, basePrice);
		}

		/**
		 * 4- Tiempo invalido -> Se lanza la excepci�n
		 * GIVEN
		 * WHEN Se crea con par�metro tiempo menor a 0 
		 * THEN Se lanza la excepci�n
		 */
		@Test(expected = IllegalArgumentException.class)
		public void testConstructorInvalidTime() {
			new Book(theTitle, theAuthor, null, theIsbn, basePrice);
		}

		/**
		 * 5- Numero de pistas invalido -> Se lanza la excepci�n
		 * GIVEN
		 * WHEN Se crea con par�metro pistas menor a 0 
		 * THEN Se lanza la excepci�n
		 */
		@Test(expected = IllegalArgumentException.class)
		public void testConstructorInvalidTracks() {
			new Book(theTitle, theAuthor, theEditorial, null, basePrice);
		}
		
		/**
		 * 6- Precio invalido -> Se lanza la excepci�n
		 * GIVEN
		 * WHEN Se crea con precio menor a 0 
		 * THEN Se lanza la excepci�n
		 */
		@Test(expected = IllegalArgumentException.class)
		public void testConstructorInvalidPrice() {
			new Book(theTitle, theAuthor, theEditorial, theIsbn, -10);
		}
}

