package uo.mp.s3.dome.model.dvd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.dome.model.Dvd;

/**
 * Titulo: Clase DvdTest
 * 
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class DvdTest {
	/**
	 * Atributo Dvd
	 */
	private Dvd aDvd;
	
	/**
	 * Atributo titulo
	 */
	private String theTitle;
	
	/**
	 * Atributo director
	 */
	private String theDirector;
	
	/**
	 * Atributo tiempo
	 */
	private int theTime;
	
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "La guerra de las Galaxias";
		theDirector = "George Lucas";
		theTime = 125;
	}

	/**
	 * Pruebas del constructor con par�metros de la clase Cd:
	 * Pruebas de funcionalidad:
	 * 1- Par�metros validos -> Se crea el objeto
	 * 
	 * Pruebas de robustez:
	 * 2- Titulo invalido -> Se lanza la excepci�n
	 * 3- Director invalido -> Se lanza la excepci�n
	 * 4- Tiempo invalido -> Se lanza la excepci�n
	 */

//Pruebas de funcionalidad:
	/**
	 * GIVEN: WHEN: Se crea con par�metros v�lidos THEN: se crea y los valores se
	 * asignan a los atributos
	 */
	@Test
	public void validParams() {
		aDvd = new Dvd(theTitle, theDirector, theTime);

		assertEquals(theTitle, aDvd.getTitle());
		assertEquals(theDirector, aDvd.getDirector());
		assertEquals(theTime, aDvd.getPlayingTime());
		assertTrue(aDvd.getOwn());
		assertEquals("No comment", aDvd.getComment());
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
			new Dvd(null, theDirector, theTime);
		}

		/**
		 * 3- Director invalido -> Se lanza la excepci�n
		 * GIVEN
		 * WHEN Se crea con par�metro artista null 
		 * THEN Se lanza la excepci�n
		 */
		@Test(expected = IllegalArgumentException.class)
		public void testConstructorInvalidArtis() {
			new Dvd(theTitle, null, theTime);
		}

		/**
		 * 4- Tiempo invalido -> Se lanza la excepci�n
		 * GIVEN
		 * WHEN Se crea con par�metro tiempo menor a 0 
		 * THEN Se lanza la excepci�n
		 */
		@Test(expected = IllegalArgumentException.class)
		public void testConstructorInvalidTime() {
			new Dvd(theTitle, theDirector, -10);
		}
}
