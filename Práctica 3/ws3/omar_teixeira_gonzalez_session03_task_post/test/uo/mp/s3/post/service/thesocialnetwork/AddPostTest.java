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
	 * Atributo librería
	 */
	private TheSocialNetwork network;
	
	/**
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void SetUp() {
		network = new TheSocialNetwork();
		photo = new Photo("Omitg","CreatorFile");
		message = new Message("Diana1806","Hola!");		
	}
	
	/**
	 * Pruebas del método addPost de la clase TheSocialNetwork: 
	 * Pruebas de funcionalidad:
	 * 1- Añade una foto  -> Se añade
	 * 2- Añade un mensaje  -> Se añade
	 * 3- Añade ambos -> Se añaden 
	 * 
	 * Pruebas de robustez:
	 * 4- Añade null -> Se lanza la excepción
	 */

//Pruebas de funcionalidad:
	/**
	 * 1- Añade una foto  -> Se añade
	 * GIVEN Se pasa una lista de post y varios productos
	 * WHEN Se añade una foto
	 * THEN Se comprueba que se ha añadido un post
	 */
	@Test
	public void testAddPhoto() {
		network.addPost(photo);
		assertEquals(1,network.getNumberOfPosts());
	}
	
	/**
	 * 2- Añade un mensaje  -> Se añade
	 * GIVEN Se pasa una lista de post y varios productos
	 * WHEN Se añade un mensaje
	 * THEN Se comprueba que se ha añadido un post
	 */
	@Test
	public void testAddMessage() {
		network.addPost(message);
		assertEquals(1,network.getNumberOfPosts());
	}
	
	/**
	 * 3- Añade ambos -> Se añaden
	 * GIVEN Se pasa una lista de post y varios productos
	 * WHEN Se añade una foto y un mensaje
	 * THEN Se comprueba que se han añadido dos post
	 */
	@Test
	public void testAddBoth() {
		network.addPost(photo);
		network.addPost(message);
		assertEquals(2,network.getNumberOfPosts());
	}
	
//Pruebas de robustez:
	/**
	 * 4- Añade null -> Se lanza la excepción
	 * GIVEN Se pasa una lista de post y varios productos
	 * WHEN Se pasa para añadir null
	 * THEN Se lanza la excepción
	 */
	 @Test
	 (expected=IllegalArgumentException.class)
	 public void testAddPostNull() {
		 network.addPost(null);
	 }
}
