package uo.mp.s5.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Cd;
import uo.mp.s5.dome.model.Dvd;
import uo.mp.s5.dome.model.Item;
import uo.mp.s5.dome.model.VideoGame;
import uo.mp.s5.dome.model.VideoGame.Platform;
import uo.mp.s5.dome.service.MediaLibrary;
/**
 * Titulo: Clase GetNumberOfItemsOwnedTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class GetNumberOfItemsOwnedTest {
	/**
	 * Atributo cd
	 */
	private Item cd1;
	
	/**
	 * Atributo cd
	 */
	private Item cd2;
	
	/**
	 * Atributo dvd
	 */
	private Item dvd1;
	
	/**
	 * Atributo dvd
	 */
	private Item dvd2;
	
	/**
	 * Atributo game
	 */
	private Item game1;
	
	/**
	 * Atributo game
	 */
	private Item game2;
	
	/**
	 * Atributo game
	 */
	private Item game3;
	
	/**
	 * Atributo librería
	 */
	private MediaLibrary lib;
	
	/**
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void SetUp() {
		lib = new MediaLibrary();
		cd1 = new Cd("TIM", "Avicii", 12, 38, 19.99);
		cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 28, 146, 39.99);
		dvd1 = new Dvd("Inception","Christopher Nolan", 162, 19.99);
		dvd2 = new Dvd("Gladiator","Ridley Scott", 171, 35.0);
		game1 = new VideoGame("God of War (2018)","Cory Barlog", 1, Platform.PLAYSTATION, 69.99);
		game2 = new VideoGame("Batman: Arkham Knight","Sefton Hill", 1, Platform.XBOX, 49.99);
		game3 = new VideoGame("Mario Kart 8","Kosuke Yabuki", 4, Platform.NINTENDO, 59.99);
		lib.add(cd1);
		lib.add(cd2);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
	}
	
	/**
	 * Pruebas del método getNumberOfItemsOwned de la clase MediaLibrary:
	 * 1- Se poseen todos los objetos -> Devuelve el total de objetos
	 * 2- Se poseen algunos objetos -> Devuelve el numero de objetos que se poseen
	 * 3- No se posee ningun objeto -> Devuelve 0
	 */
	
	/**  
	 * 1- Se poseen todos los objetos -> Devuelve el total de objetos
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se añaden todos los objetos (todos se poseen)
	 * THEN Se posee el total de los objetos
	 */
	@Test
	public void testGetNumberOfItemsOwnedAll() {
		cd1.setOwn(true);
		cd2.setOwn(true);
		dvd1.setOwn(true);
		dvd2.setOwn(true);
		game1.setOwn(true);
		game2.setOwn(true);
		game3.setOwn(true);
		assertEquals(7,lib.getNumberOfItemsOwned());
	}
	
	/**  
	 * 2- Se poseen algunos objetos -> Devuelve el numero de objetos que se poseen
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se añaden todos los objetos (algunos se poseen)
	 * THEN Se poseen algunos los objetos
	 */
	@Test
	public void testGetNumberOfItemsOwnedSome() {
		cd1.setOwn(true);
		dvd1.setOwn(true);
		game3.setOwn(true);
		assertEquals(3,lib.getNumberOfItemsOwned());
	}
	
	/**  
	 * 3- No se posee ningun objeto -> Devuelve 0
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se añaden todos los objetos (ninguno se posee)
	 * THEN Se comprueba que no hay ninguno
	 */
	@Test
	public void testGetNumberOfItemsOwnedNone() {
		assertEquals(0,lib.getNumberOfItemsOwned());
	}
}
