package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.model.VideoGame.Platform;
import uo.mp.s4.dome.service.MediaLibrary;

/**
 * Titulo: Clase TotalValueTest
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class TotalValueTest {
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
	 * 1- Valor total de un CD
	 * 2- Valor total de un DVD
	 * 3- Valor total de un VideoGame
	 * 4- Valor total de 2 CDs
	 * 5- Valor total de 3 DVDs
	 * 6- Valor total de 3 VideoGames
	 * 7- Valor total de varios productos
	 * 8- Valor total de muchos productos
	 */
	
	/**
	 * 1- Valor total de un CD
	 * GIVEN Se crean varios productos y una libreria
	 * WHEN Se añade un CD a la lista
	 * THEN Se comprueba que el valor devuelto con TotalValue es el correcto
	 */
	@Test
	public void testTotalCD() {
		lib.add(cd1);
		assertEquals(21.99,lib.totalValue(),0.1);
	}
	
	/**
	 * 2- Valor total de un DVD
	 * GIVEN Se crean varios productos y una libreria
	 * WHEN Se añade un DVD a la lista
	 * THEN Se comprueba que el valor devuelto con TotalValue es el correcto
	 */
	@Test
	public void testTotalDVD() {
		lib.add(dvd1);
		assertEquals(19.99,lib.totalValue(),0.1);
	}
	
	/**
	 * 3- Valor total de un VideoGame
	 * GIVEN Se crean varios productos y una libreria
	 * WHEN Se añade un GAME a la lista
	 * THEN Se comprueba que el valor devuelto con TotalValue es el correcto
	 */
	@Test
	public void testTotalGAME() {
		lib.add(game1);
		assertEquals(76.989,lib.totalValue(),0.1);
	}
	
	/**
	 * 4- Valor total de 2 CDs
	 * GIVEN Se crean varios productos y una libreria
	 * WHEN Se añaden dos CDs a la lista
	 * THEN Se comprueba que el valor devuelto con TotalValue es el correcto
	 */
	@Test
	public void testTotalCDs() {
		lib.add(cd1);
		lib.add(cd2);
		assertEquals(63.98,lib.totalValue(),0.1);
	}
	
	/**
	 * 5- Valor total de 3 DVDs
	 * GIVEN Se crean varios productos y una libreria
	 * WHEN Se añaden tres DVDs a la lista
	 * THEN Se comprueba que el valor devuelto con TotalValue es el correcto
	 */
	@Test
	public void testTotalDVDs() {
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(dvd3);
		assertEquals(174.98,lib.totalValue(),0.1);
	}
	
	/**
	 * 6- Valor total de 3 VideoGames
	 * GIVEN Se crean varios productos y una libreria
	 * WHEN Se añaden tres GAMEs a la lista
	 * THEN Se comprueba que el valor devuelto con TotalValue es el correcto
	 */
	@Test
	public void testTotalGAMEs() {
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
		assertEquals(197.967,lib.totalValue(),0.1);
	}
	
	/**
	 * 7- Valor total de varios productos
	 * GIVEN Se crean varios productos y una libreria
	 * WHEN Se añaden varios productos a la lista 
	 * THEN Se comprueba que el valor devuelto con TotalValue es el correcto
	 */
	@Test
	public void testTotalVariousProducts() {
		lib.add(cd1);
		lib.add(dvd1);
		lib.add(dvd1);
		assertEquals(61.97,lib.totalValue(),0.1);
	}
	
	/**
	 * 8- Valor total de muchos productos
	 * GIVEN Se crean varios productos y una libreria
	 * WHEN Se añaden todos los productos a la lista
	 * THEN Se comprueba que el valor devuelto con TotalValue es el correcto
	 */
	@Test
	public void testTotalAllProducts() {
		lib.add(cd1);
		lib.add(cd2);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(dvd3);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);		
		assertEquals(436.927,lib.totalValue(),0.1);
	}
}
