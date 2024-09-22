package uo.mp.s5.dome.model.videogame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.VideoGame;
import uo.mp.s5.dome.model.VideoGame.Platform;

/**
 * Titulo: Clase ToStringTest
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class ToStringTest {
	/**
	 * Atributos game
	 */
	private VideoGame game1, game2, game3;
		
	/**
	 * Creación de atributos para su posterior uso
	 */
	@Before
	public void setUp() {		
		game1 = new VideoGame("God of War (2018)","Cory Barlog", 1, 
				Platform.PLAYSTATION, 69.99);
		game2 = new VideoGame("Batman: Arkham Knight","Sefton Hill", 1, 
				Platform.XBOX, 49.99);
		game3 = new VideoGame("Mario Kart 8","Kosuke Yabuki", 4, 
				Platform.NINTENDO, 59.99);
	}
	
	/**
	 * Pruebas del método toString de la calse Cd:
	 * 1- toString a game1
	 * 2- toString a game2
	 * 3- toString a game3
	 */
	
	/**
	 * 1- toString a game1
	 * GIVEN Se crean varios Games
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test1() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: God of War (2018)\n"
				+ "Base price: 69.99 $\n"
				+ "Final price: 76.98899999999999 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "Game Director: Cory Barlog\n"
				+ "Number of players: 1\n"
				+ "Platform: PLAYSTATION\n";
		assertEquals(expected, game1.toString());
	}
	
	/**
	 * 2- toString a game2
	 * GIVEN Se crean varios Games
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test2() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: Batman: Arkham Knight\n"
				+ "Base price: 49.99 $\n"
				+ "Final price: 54.989000000000004 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "Game Director: Sefton Hill\n"
				+ "Number of players: 1\n"
				+ "Platform: XBOX\n";
		assertEquals(expected, game2.toString());
	}
	
	/**
	 * 3- toString a game3
	 * GIVEN Se crean varios Games
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test3() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: Mario Kart 8\n"
				+ "Base price: 59.99 $\n"
				+ "Final price: 65.989 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "Game Director: Kosuke Yabuki\n"
				+ "Number of players: 4\n"
				+ "Platform: NINTENDO\n";
		assertEquals(expected, game3.toString());
	}
}
