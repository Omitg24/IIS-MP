package uo.mp.s2.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.dome.model.Cd;
import uo.mp.s3.dome.model.Dvd;
import uo.mp.s3.dome.model.Item;
import uo.mp.s3.dome.model.VideoGame;
import uo.mp.s3.dome.model.VideoGame.Platform;
import uo.mp.s3.dome.service.MediaLibrary;
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
	 * Atributo librer�a
	 */
	private MediaLibrary lib;
	
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void SetUp() {
		lib = new MediaLibrary();
		cd1 = new Cd("TIM", "Avicii", 12, 38);
		cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 28, 146);
		dvd1 = new Dvd("Inception","Christopher Nolan", 162);
		dvd2 = new Dvd("Gladiator","Ridley Scott", 171);
		game1 = new VideoGame("God of War (2018)","Cory Barlog", 1, Platform.PLAYSTATION);
		game2 = new VideoGame("Batman: Arkham Knight","Sefton Hill",1, Platform.XBOX);
		game3 = new VideoGame("Mario Kart 8","Kosuke Yabuki",4, Platform.NINTENDO);
		lib.add(cd1);
		lib.add(cd2);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
	}
	
	/**
	 * Pruebas del m�todo getNumberOfItemsOwned de la clase MediaLibrary:
	 * 1- Se poseen todos los objetos -> Devuelve el total de objetos
	 * 2- Se poseen algunos objetos -> Devuelve el numero de objetos que se poseen
	 * 3- No se posee ningun objeto -> Devuelve 0
	 */
	
	/**  
	 * 1- Se poseen todos los objetos -> Devuelve el total de objetos
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se a�aden todos los objetos (todos se poseen)
	 * THEN Se posee el total de los objetos
	 */
	@Test
	public void testGetNumberOfItemsOwnedAll() {
		assertEquals(7,lib.getNumberOfItemsOwned());
	}
	
	/**  
	 * 2- Se poseen algunos objetos -> Devuelve el numero de objetos que se poseen
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se a�aden todos los objetos (algunos se poseen)
	 * THEN Se poseen algunos los objetos
	 */
	@Test
	public void testGetNumberOfItemsOwnedSome() {
		cd1.setOwn(false);
		dvd1.setOwn(false);
		game3.setOwn(false);
		assertEquals(4,lib.getNumberOfItemsOwned());
	}
	
	/**  
	 * 3- No se posee ningun objeto -> Devuelve 0
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se a�aden todos los objetos (ninguno se posee)
	 * THEN Se comprueba que no hay ninguno
	 */
	@Test
	public void testGetNumberOfItemsOwnedNone() {
		cd1.setOwn(false);
		cd2.setOwn(false);
		dvd1.setOwn(false);
		dvd2.setOwn(false);
		game1.setOwn(false);
		game2.setOwn(false);
		game3.setOwn(false);
		assertEquals(0,lib.getNumberOfItemsOwned());
	}
}
