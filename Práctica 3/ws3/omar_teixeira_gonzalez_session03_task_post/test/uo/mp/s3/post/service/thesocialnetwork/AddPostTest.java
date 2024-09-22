package uo.mp.s3.post.service.thesocialnetwork;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.post.model.Message;
import uo.mp.s3.post.model.Photo;
import uo.mp.s3.post.model.Post;
import uo.mp.s3.post.service.TheSocialNetwork;

/**
 * Titulo: Clase AddPostTest
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class AddPostTest {
	/**
	 * Atributo cd
	 */
	private Post photo;
	/**
	 * Atributo dvd
	 */
	private Post message;
	
	/**
	 * Atributo librer�a
	 */
	private TheSocialNetwork network;
	
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void SetUp() {
		network = new TheSocialNetwork();
		photo = new Photo("Omitg","CreatorFile");
		message = new Message("Diana1806","Hola!");		
	}
	
	/**
	 * Pruebas del m�todo addPost de la clase TheSocialNetwork: 
	 * Pruebas de funcionalidad:
	 * 1- A�ade una foto  -> Se a�ade
	 * 2- A�ade un mensaje  -> Se a�ade
	 * 3- A�ade ambos -> Se a�aden 
	 * 
	 * Pruebas de robustez:
	 * 4- A�ade null -> Se lanza la excepci�n
	 */

//Pruebas de funcionalidad:
	/**
	 * 1- A�ade una foto  -> Se a�ade
	 * GIVEN Se pasa una lista de post y varios productos
	 * WHEN Se a�ade una foto
	 * THEN Se comprueba que se ha a�adido un post
	 */
	@Test
	public void testAddPhoto() {
		network.addPost(photo);
		assertEquals(1,network.getNumberOfPosts());
	}
	
	/**
	 * 2- A�ade un mensaje  -> Se a�ade
	 * GIVEN Se pasa una lista de post y varios productos
	 * WHEN Se a�ade un mensaje
	 * THEN Se comprueba que se ha a�adido un post
	 */
	@Test
	public void testAddMessage() {
		network.addPost(message);
		assertEquals(1,network.getNumberOfPosts());
	}
	
	/**
	 * 3- A�ade ambos -> Se a�aden
	 * GIVEN Se pasa una lista de post y varios productos
	 * WHEN Se a�ade una foto y un mensaje
	 * THEN Se comprueba que se han a�adido dos post
	 */
	@Test
	public void testAddBoth() {
		network.addPost(photo);
		network.addPost(message);
		assertEquals(2,network.getNumberOfPosts());
	}
	
//Pruebas de robustez:
	/**
	 * 4- A�ade null -> Se lanza la excepci�n
	 * GIVEN Se pasa una lista de post y varios productos
	 * WHEN Se pasa para a�adir null
	 * THEN Se lanza la excepci�n
	 */
	 @Test
	 (expected=IllegalArgumentException.class)
	 public void testAddPostNull() {
		 network.addPost(null);
	 }
}
