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
 * Titulo: Clase GetItemsTest
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class GetItemsTest {
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
	}
	
	/**
	 * Pruebas del m�todo getItems de la clase MediaLibrary:
	 * 1- Hay un objeto a�adido 
	 * 2- Hay varios objetos a�adidos
	 * 3- No hay objetos a�adidos
	 */
	
	/**
	 * 1- Hay un objeto a�adido
	 * GIVEN Se crea una libreria y varios productos
	 * WHEN Se a�ade un objeto a la lista
	 * THEN Se comprueba que hay un objeto en la lista
	 */
	@Test
	public void testGetItemsOne() {
		lib.add(cd1);
		assertEquals(1,lib.getItems().size());
	}
	
	/**
	 * 1- Hay un objeto a�adido
	 * GIVEN Se crea una libreria y varios productos
	 * WHEN Se a�aden todos los objetos a la lista
	 * THEN Se comprueba que hay 7 objetos en la lista
	 */
	@Test
	public void testGetItemsMany() {
		lib.add(cd1);
		lib.add(cd2);
		lib.add(dvd1);
		lib.add(dvd2);
		lib.add(game1);
		lib.add(game2);
		lib.add(game3);
		assertEquals(7,lib.getItems().size());
	}
	
	/**
	 * 3- No hay objetos a�adidos
	 * GIVEN Se crea una libreria y varios productos
	 * WHEN 
	 * THEN Se comprueba que no hay nada
	 */
	@Test
	public void testGetItemsEmpty() {
		assertEquals(0,lib.getItems().size());
	}
}
