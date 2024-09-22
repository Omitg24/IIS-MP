package uo.mp.s4.dome.model.videogame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.model.VideoGame.Platform;

/**
 * Titulo: Clase VideoGameTest
 * 
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class VideoGameTest {
	/**
	 * Atributo theTittle, titulo del VideoGame
	 */
	private String theTitle;
	/**
	 * Atributo theArtist, artista del VideoGame
	 */
	private String theAuthor;
	
	/**
	 * Atributo players, numero de jugadores
	 */
	private int players;
	
	/**
	 * Atributo platform, plataforma del VideoGame
	 */
	private VideoGame.Platform platform;
	
	/**
	 * Atributo basePrice, precio base
	 */
	private double basePrice;
	
	/**
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "God of War";
		theAuthor = "Cory Barlog";
		players = 1;
		basePrice = 69.9;
		platform=Platform.PLAYSTATION;
	}
	
	/**
	 * Pruebas del constructor con parámetros de la clase Cd:
	 * Pruebas de funcionalidad:
	 * 1- Parámetros validos -> Se crea el objeto
	 * 
	 * Pruebas de robustez:
	 * 2- Titulo invalido -> Se lanza la excepción
	 * 3- Autor invalido -> Se lanza la excepción
	 * 4- Numero de jugadores invalido -> Se lanza la excepción
	 * 5- Precio invalido -> Se lanza la excepción
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
		VideoGame game = new VideoGame(theTitle, theAuthor, players, platform, basePrice);

		assertEquals("God of War", game.getTitle());
		assertEquals("Cory Barlog", game.getGameDirector());		
		assertEquals(1, game.getPlayers());
		assertTrue(game.getOwn());
		assertEquals("No comment", game.getComment());
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
		new VideoGame(null, theAuthor, players, platform, basePrice);
	}

	/**
	 * 3- Autor invalido -> Se lanza la excepción
	 * GIVEN
	 * WHEN Se crea con parámetro autor null 
	 * THEN Se lanza la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArtis() {
		new VideoGame(theTitle, null, players, platform, basePrice);
	}

	/**
	 * 4- Numero de jugadores invalido -> Se lanza la excepción
	 * GIVEN
	 * WHEN Se crea con parámetro jugadores menor a 0 
	 * THEN Se lanza la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTime() {
		new VideoGame(theTitle, theAuthor, -10, platform, basePrice);
	}	
	
	/**
	 * 5- Precio invalido -> Se lanza la excepción
	 * GIVEN
	 * WHEN Se crea con parámetro precio menor a 0 
	 * THEN Se lanza la excepción
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidPrice() {
		new VideoGame(theTitle, theAuthor, players, platform, -10);
	}	
}