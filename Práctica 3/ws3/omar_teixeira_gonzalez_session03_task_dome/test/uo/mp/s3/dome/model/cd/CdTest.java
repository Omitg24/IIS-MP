package uo.mp.s3.dome.model.cd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.dome.model.Cd;

/**
 * Titulo: Clase CdTest
 * 
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class CdTest {
	/**
	 * Atributo theTittle, titulo del CD
	 */
	private String theTitle;
	/**
	 * Atributo theArtist, artista del CD
	 */
	private String theArtist;
	/**
	 * Atributo theTIme, tiempo de duraci�n del CD
	 */
	private int theTime;
	/**
	 * Atributo theTracks, numero de pistas que hay en el CD
	 */
	private int theTracks;
	
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "Come Together";
		theArtist = "Beatles";
		theTime = 70;
		theTracks = 4;
	}
	
	/**
	 * Pruebas del constructor con par�metros de la clase Cd:
	 * Pruebas de funcionalidad:
	 * 1- Par�metros validos -> Se crea el objeto
	 * 
	 * Pruebas de robustez:
	 * 2- Titulo invalido -> Se lanza la excepci�n
	 * 3- Artista invalido -> Se lanza la excepci�n
	 * 4- Tiempo invalido -> Se lanza la excepci�n
	 * 5- Numero de pistas invalido -> Se lanza la excepci�n
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
		Cd cd = new Cd(theTitle, theArtist, theTracks, theTime);

		assertEquals("Come Together", cd.getTitle());
		assertEquals("Beatles", cd.getArtist());
		assertEquals(70, cd.getPlayingTime());
		assertEquals(4, cd.getNumberOfTracks());
		assertTrue(cd.getOwn());
		assertEquals("No comment", cd.getComment());
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
		new Cd(null, theArtist, theTime, theTracks);
	}

	/**
	 * 3- Artista invalido -> Se lanza la excepci�n
	 * GIVEN
	 * WHEN Se crea con par�metro artista null 
	 * THEN Se lanza la excepci�n
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArtis() {
		new Cd(theTitle, null, theTime, theTracks);
	}

	/**
	 * 4- Tiempo invalido -> Se lanza la excepci�n
	 * GIVEN
	 * WHEN Se crea con par�metro tiempo menor a 0 
	 * THEN Se lanza la excepci�n
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTime() {
		new Cd(theTitle, theArtist, -10, theTracks);
	}

	/**
	 * 5- Numero de pistas invalido -> Se lanza la excepci�n
	 * GIVEN
	 * WHEN Se crea con par�metro pistas menor a 0 
	 * THEN Se lanza la excepci�n
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTracks() {
		new Cd(theTitle, theArtist, theTime, -10);
	}
}
