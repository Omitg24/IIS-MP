package uo.mp.s5.dome.model.cd;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Cd;

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
	 * Atributo theTIme, tiempo de duración del CD
	 */
	private int theTime;
	/**
	 * Atributo theTracks, numero de pistas que hay en el CD
	 */
	private int theTracks;
	
	/**
	 * Atributo basePrice, precio base
	 */
	private double basePrice;
	
	/**
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "Come Together";
		theArtist = "Beatles";
		theTime = 70;
		theTracks = 4;
		basePrice= 49.9;
	}
	
	/**
	 * Pruebas del constructor con parámetros de la clase Cd:
	 * Pruebas de funcionalidad:
	 * 1- Parámetros validos -> Se crea el objeto
	 * 
	 * Pruebas de robustez:
	 * 2- Titulo invalido -> Se lanza la excepción
	 * 3- Artista invalido -> Se lanza la excepción
	 * 4- Tiempo invalido -> Se lanza la excepción
	 * 5- Numero de pistas invalido -> Se lanza la excepción
	 * 6- Precio invalido -> Se lanza la excepción
	 */
	
//Pruebas de funcionamiento:
	/**
	 * 1- Parámetros validos -> Se crea el objeto
	 * GIVEN
	 * WHEN Se crea con parámetros válidos 
	 * THEN: se crea y los valores se asignan a los atributos
	 */
	@Test
	public void testConstructorValidParams() {
		Cd cd = new Cd(theTitle, theArtist, theTracks, theTime, basePrice);

		assertEquals("Come Together", cd.getTitle());
		assertEquals("Beatles", cd.getArtist());
		assertEquals(70, cd.getPlayingTime());
		assertEquals(4, cd.getNumberOfTracks());		
		assertEquals("No comment", cd.getComment());
		assertEquals(49.9, cd.getBasePrice(),0.1);		
	}
//Pruebas de robustez:
	/**
	 * 2- Titulo invalido -> Se lanza la excepción
	 * GIVEN
	 * WHEN Se crea con parámetro titulo null 
	 * THEN Se lanza la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTittle() {
		new Cd(null, theArtist, theTime, theTracks, basePrice);
	}

	/**
	 * 3- Artista invalido -> Se lanza la excepción
	 * GIVEN
	 * WHEN Se crea con parámetro artista null 
	 * THEN Se lanza la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArtis() {
		new Cd(theTitle, null, theTime, theTracks, basePrice);
	}

	/**
	 * 4- Tiempo invalido -> Se lanza la excepción
	 * GIVEN
	 * WHEN Se crea con parámetro tiempo menor a 0 
	 * THEN Se lanza la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTime() {
		new Cd(theTitle, theArtist, -10, theTracks, basePrice);
	}

	/**
	 * 5- Numero de pistas invalido -> Se lanza la excepción
	 * GIVEN
	 * WHEN Se crea con parámetro pistas menor a 0 
	 * THEN Se lanza la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTracks() {
		new Cd(theTitle, theArtist, theTime, -10, basePrice);
	}
	
	/**
	 * 6- Precio invalido -> Se lanza la excepción
	 * GIVEN
	 * WHEN Se crea con precio menor a 0 
	 * THEN Se lanza la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidPrice() {
		new Cd(theTitle, theArtist, theTime, theTracks, -10);
	}
}
