package uo.mp.s5.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Cd;
import uo.mp.s5.dome.model.Dvd;
import uo.mp.s5.dome.model.VideoGame;
import uo.mp.s5.dome.model.VideoGame.Platform;
import uo.mp.s5.dome.service.MediaLibrary;

/**
 * Titulo: Clase TotalValueTest
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class GenerateCodeTest {
	/**
	 * Atributos cd
	 */
	private Cd cd1, cd2;
	
	/**
	 * Atributos dvd
	 */
	private Dvd dvd1, dvd2, dvd3;
	
	/**
	 * Atributos game
	 */
	private VideoGame game1, game2, game3;
	
	/**
	 * Atributo lib
	 */
	private MediaLibrary lib;
	
	/**
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		lib = new MediaLibrary();
		cd1 = new Cd("TIM", "Avicii", 12, 38, 19.99);
		cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 
			28, 146, 39.99);
		dvd1 = new Dvd("Inception","Christopher Nolan", 162, 19.99);
		dvd2 = new Dvd("Gladiator","Ridley Scott", 171, 35.0);
		dvd3 = new Dvd("Vikings: Full Series", "Michael Hirst", 4005, 119.99);
		game1 = new VideoGame("God of War (2018)","Cory Barlog", 1, 
			Platform.PLAYSTATION, 69.99);
		game2 = new VideoGame("Batman: Arkham Knight","Sefton Hill", 1, 
			Platform.XBOX, 49.99);
		game3 = new VideoGame("Mario Kart 8","Kosuke Yabuki", 4, 
			Platform.NINTENDO, 59.99);
	}
	
	/**
	 * Pruebas del método totalValue de la clase MediaLibrary:
	 * 1- Un CD en la lista
	 * 2- Un DVD en la lista
	 * 3- Un GAME en la lista
	 * 4- Varios items en la lista
	 * 5- Todos los items en la lista
	 */
	
	/**
	 * 1- Un CD en la lista
	 * GIVEN Se crean varios items y una libreria
	 * WHEN Se añade un cd
	 * THEN Se comprueba que el codigo del item es igual al esperado
	 */
	@Test
	public void testCodeCD() {
		lib.add(cd1);
		String expected ="TIM0"; 
		assertEquals(expected,lib.generateCode());
	}
	
	/**
	 * 2- Un DVD en la lista
	 * GIVEN Se crean varios items y una libreria
	 * WHEN Se añade un dvd
	 * THEN Se comprueba que el codigo del item es igual al esperado
	 */
	@Test
	public void testCodeDVD() {
		lib.add(dvd1);
		String expected ="Inc0"; 
		assertEquals(expected,lib.generateCode());
	}
	
	/**
	 * 3- Un GAME en la lista
	 * GIVEN Se crean varios items y una libreria
	 * WHEN Se añade un game
	 * THEN Se comprueba que el codigo del item es igual al esperado
	 */
	@Test
	public void testCodeGAME() {
		lib.add(game1);
		String expected ="God0"; 
		assertEquals(expected,lib.generateCode());
	}
	
	/**
	 * 4- Varios items en la lista
	 * GIVEN Se crean varios items y una libreria
	 * WHEN Se añaden varios items
	 * THEN Se comprueba que el codigo de los items es igual al esperado
	 */
	@Test
	public void testCodeVarious() {
		lib.add(cd1);
		lib.add(dvd1);
		lib.add(game1);
		String expected ="TIM0-Inc1-God2"; 
		assertEquals(expected,lib.generateCode());
	}
	
	/**
	 * 5- Todos los items en la lista
	 * GIVEN Se crean varios items y una libreria
	 * WHEN Se añaden todos los items
	 * THEN Se comprueba que el codigo de los items es igual al esperado
	 */
	@Test
	public void testCodeAll() {
		lib.add(cd1);
		lib.add(cd2);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(dvd3);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
		String expected ="TIM0-The1-Inc2-Gla3-Vik4-God5-Bat6-Mar7"; 
		assertEquals(expected,lib.generateCode());
	}
	
}