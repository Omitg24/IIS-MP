package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.Item;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.model.VideoGame.Platform;
import uo.mp.s4.dome.service.MediaLibrary;
/**
 * Titulo: Clase SearchTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class SearchTest {
	/**
	 * Atributo cd
	 */
	private Item cd1, cd2, cdEqual;
	
	/**
	 * Atributo dvd
	 */
	private Item dvd1, dvd2, dvdEqual;
	
	/**
	 * Atributo game
	 */
	private Item game1, game2, game3, gameEqual, gameEqual2, gameSearchFail;
	
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
		cdEqual= new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 28, 146, 39.99);
		dvd1 = new Dvd("Inception","Christopher Nolan", 162, 19.99);
		dvd2 = new Dvd("Gladiator","Ridley Scott", 171, 35.0);
		dvdEqual = new Dvd("Gladiator","Ridley Scott", 171, 35.0);
		game1 = new VideoGame("God of War (2018)","Cory Barlog", 1, Platform.PLAYSTATION, 69.99);
		game2 = new VideoGame("Batman: Arkham Knight","Sefton Hill", 1, Platform.XBOX, 49.99);
		game3 = new VideoGame("Mario Kart 8","Kosuke Yabuki", 4, Platform.NINTENDO, 59.99);
		gameEqual = new VideoGame("God of War (2018)","Cory Barlog", 1, Platform.PLAYSTATION, 69.99);
		gameEqual2 = new VideoGame("Batman: Arkham Knight","Sefton Hill",1, Platform.XBOX, 49.99);
		gameSearchFail = new VideoGame("The Last of Us", "Neil Druckmann", 1, Platform.PLAYSTATION, 59.99);
		lib.add(cd1);
		lib.add(cd2);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
	}
	
	/**
	 * Pruebas del método searchItem de la clase MediaLibrary:
	 * Pruebas de funcionalidad:
	 * 1- Se busca un objeto que esta -> Devuelve su posicion
	 * 2- Se buscan varios objetos que estan -> Devuelve sus posiciones
	 * 3- Se busca un objeto que no esta -> Devuelve -1
	 * 
	 * Pruebas de robustez:
	 * 4- Se pasa como parámetro null -> Lanza la excepción
	 */
	
//Pruebas de funcionalidad:
	/**
	 * 1- Se busca un objeto que esta -> Devuelve su posicion
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se añaden a la lista y se busca uno presente en esta
	 * THEN Se comprueba que se devuelve la posicion en la que esta
	 */
	 @Test
	 public void testSearchItemOne() {
		 assertEquals(4,lib.search(gameEqual));
	 }
	 
	 /**
	  * 2- Se buscan varios objetos que estan -> Devuelve sus posiciones
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se añaden a la lista y se buscan varios presentes en esta
	 * THEN Se comprueba que se devuelve la posicion en la que estan
	 */
	 @Test
	 public void testSearchItemMany() {
		 assertEquals(1,lib.search(cdEqual));
		 assertEquals(3,lib.search(dvdEqual));
		 assertEquals(4,lib.search(gameEqual));
		 assertEquals(5,lib.search(gameEqual2));
	 }
	 
	 /**
	  * 3- Se busca un objeto que no esta -> Devuelve -1
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se añaden a la lista y se busca uno no presente en esta
	 * THEN Se comprueba que se devuelve -1 al no esta en la lista
	 */
	 @Test
	 public void testSearchItemNot() {
		 assertEquals(-1,lib.search(gameSearchFail));
	 }

//Pruebas de robustez:
	 /**
	  * 4- Se pasa como parámetro null -> Lanza la excepción
	 * GIVEN Se crea una libreria y varios objetos
	 * WHEN Se añaden a la lista y se busca un null
	 * THEN Se lanza la excepción
	 */
	 @Test
	 (expected=IllegalArgumentException.class)
	 public void testSearchItemNull() {
		 lib.search(null);
	 }
}
