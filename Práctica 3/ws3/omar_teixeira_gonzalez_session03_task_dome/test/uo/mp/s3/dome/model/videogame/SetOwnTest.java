package uo.mp.s3.dome.model.videogame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.dome.model.Item;
import uo.mp.s3.dome.model.VideoGame;
import uo.mp.s3.dome.model.VideoGame.Platform;

/**
 * Titulo: Clase SetOwnTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class SetOwnTest {
	/**
	 * Atributo VideoGame
	 */
	private Item game;	
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
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		theTitle = "God of War";
		theAuthor = "Cory Barlog";
		players = 1;
		platform=Platform.PLAYSTATION;
		game= new VideoGame(theTitle, theAuthor, players, platform);
	}

	/**
	 * Pruebas del m�todo setOwn de la clase Dvd:
	 * 1- Se pasa true dos veces
	 * 2- Se pasa true y posteriormente se pasa false
	 * 3- Se pasa false dos veces
	 * 4- Se pasa false y posteriormente se pasa true 
	 */
	
	/**
	 * 1- Se pasa true dos veces
	 * GIVEN cd con valor true para propietario 
	 * WHEN se invoca setOwn con true
	 * THEN el game permanece con true en propietario 
	 */
	@Test
	public void trueToTrue() {
		game.setOwn(true);
		game.setOwn(true);
		assertEquals(true, game.getOwn());
	}

	/**
	 * 2- Se pasa true y posteriormente se pasa false
	 * GIVEN cd con valor true para propietario 
	 * WHEN se invoca setOwn con false
	 * THEN el game cambia a false en propietario 
	 */
	@Test
	public void trueToFalse() {
		game.setOwn(true);
		game.setOwn(false);
		assertEquals(false, game.getOwn());
	}

	/**
	 * 3- Se pasa false dos veces
	 * GIVEN cd con valor false para propietario 
	 * WHEN se invoca setOwn con false
	 * THEN el game permanece con false en propietario 
	 */
	@Test
	public void falseToFalse() {
		game.setOwn(false);
		game.setOwn(false);
		assertEquals(false, game.getOwn());
	}

	/**
	 * 4- Se pasa false y posteriormente se pasa true
	 * GIVEN cd con valor false para propietario 
	 * WHEN se invoca setOwn con true
	 * THEN el game cambia a true en propietario
	 */
	@Test
	public void falseToTrue() {
		game.setOwn(false);
		game.setOwn(true);
		assertEquals(true, game.getOwn());
	}
}