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
 * Titulo: Clase AddTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class AddTest {
	/**
	 * Atributo cd
	 */
	private Item cd;
	/**
	 * Atributo dvd
	 */
	private Item dvd;
	/**
	 * Atributo game
	 */
	private Item game;
	
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
		cd= new Cd("TIM","Avicii",12,38);
		dvd= new Dvd("Inception","Christopher Nolan", 162);
		game = new VideoGame("Batman: Arkham Knight","Sefton Hill",1, Platform.XBOX);
	}
	
	/**
	 * Pruebas del m�todo Add de la clase MediaLibrary: 
	 * Pruebas de funcionalidad:
	 * 1- A�ade un CD  -> Se a�ade
	 * 2- A�ade un DVD  -> Se a�ade
	 * 3- A�ade un VideoGame -> Se a�ade
	 * 4- A�ade un CD y un DVD -> Se a�aden
	 * 5- A�ade un DVD y un VideoGame -> Se a�aden
	 * 6- A�ade un CD, un DVD y un VideoGame -> Se a�aden
	 * 
	 * Pruebas de robustez:
	 * 7- A�ade null -> Se lanza la excepci�n
	 */

//Pruebas de funcionalidad:
	/**
	 * 1- A�ade un CD  -> Se a�ade
	 * GIVEN Se pasa una libreria y varios productos
	 * WHEN Se a�ade un CD
	 * THEN Se comprueba que se ha a�adido un objeto
	 */
	@Test
	public void testAddCD() {
		lib.add(cd);
		assertEquals(1,lib.getItems().size());
	}
	
	/**
	 * 2- A�ade un DVD  -> Se a�ade
	 * GIVEN Se pasa una libreria y varios productos
	 * WHEN Se a�ade un DVD
	 * THEN Se comprueba que se ha a�adido un objeto
	 */
	@Test
	public void testAddDVD() {
		lib.add(dvd);
		assertEquals(1,lib.getItems().size());
	}
	
	/**
	 * 3- A�ade un VideoGame -> Se a�ade
	 * GIVEN Se pasa una libreria y varios productos
	 * WHEN Se a�ade un VideoGame
	 * THEN Se comprueba que se ha a�adido un objeto
	 */
	@Test
	public void testAddVideoGame() {
		lib.add(game);
		assertEquals(1,lib.getItems().size());
	}
	
	/**
	 * 4- A�ade un CD y un DVD -> Se a�aden
	 * GIVEN Se pasa una libreria y varios productos
	 * WHEN Se a�ade un CD y un DVD
	 * THEN Se comprueba que se han a�adido 2 objetos
	 */
	@Test
	public void testAddCDDAndDVD() {
		lib.add(cd);
		lib.add(dvd);		
		assertEquals(2,lib.getItems().size());
	}
	
	/**
	 * 5- A�ade un DVD y un VideoGame -> Se a�aden
	 * GIVEN Se pasa una libreria y varios productos
	 * WHEN Se a�ade un DVD y un VideoGame
	 * THEN Se comprueba que se han a�adido 2 objetos
	 */
	@Test
	public void testAddDVDAndideoGame() {
		lib.add(dvd);
		lib.add(game);
		assertEquals(2,lib.getItems().size());
	}
	
	/**
	 * 6- A�ade un CD, un DVD y un VideoGame -> Se a�aden
	 * GIVEN Se pasa una libreria y varios productos
	 * WHEN Se a�ade un CD, un DVD y un VIdeoGame
	 * THEN Se comprueba que se han a�adido 3 objetos
	 */
	@Test
	public void testAddAll() {
		lib.add(cd);
		lib.add(dvd);
		lib.add(game);
		assertEquals(3,lib.getItems().size());
	}
	
//Pruebas de robustez:
	/**
	 * 7- A�ade null -> Se lanza la excepci�n
	 * GIVEN Se pasa una libreria y varios productos
	 * WHEN Se a�ade null
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testAddNull() {
		lib.add(null);		
	}
}
