package uo.mp.s3.dome.model.videogame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.dome.model.Item;
import uo.mp.s3.dome.model.VideoGame;
import uo.mp.s3.dome.model.VideoGame.Platform;

/**
 * Titulo: Clase SetCommentTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class SetCommentTest {
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
	 * Creación de atributos para su uso posterior
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
	 * Pruebas del método setComment de la clase Cd:
	 * 1- Se escribe el comentario correctamente
	 * 2- Se escribe null y posteriormente el comentario correcto 
	 */
	
	/**
	 * 1- Se escribe el comentario correctamente
	 * GIVEN dvd con comentario vacío 
	 * WHEN invoca setComment con cadena no vacía como comentario 
	 * THEN se cambia el comentario a la cadena 
	 */
	@Test
	public void rigthComment() {
		game.setComment("Excellent");

		assertEquals("Excellent", game.getComment());
	}

	/**
	 * 2- Se escribe null y posteriormente el comentario correcto
	 * GIVEN dvd con comentario no vacío
	 * WHEN invoca setComment con null 
	 * THEN permanece el comentario que había
	 */
	@Test
	public void invalidComment() {
		game.setComment("Excellent");
		game.setComment(null);

		assertEquals("Excellent", game.getComment());
	}
}