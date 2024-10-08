package uo.mp.s3.post.model.photo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.post.model.Photo;

/**
 * Titulo: Clase ToStringTest
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class ToStringTest {
	/**
	 * Atributo usuario
	 */
	private String user1;
	
	/**
	 * Atributo usuario
	 */
	private String user2;
	
	/**
	 * Atributo fichero
	 */
	private String file1;
	
	/**
	 * Atributo fichero
	 */
	private String file2;
	
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		user1 = "Omitg";
		file1 = "Bienvenido";
		user2="DaneonX";
		file2 = "Buenas tardes";		
	}
	
	/**
	 * Pruebas del m�todo toString de la clase Message:
	 * 1- Recibe un usuario 1
	 * 2- Recibe un usuario 2
	 */
	
	/**
	 * 1- Recibe un usuario 1
	 * GIVEN Se crea un usuario dado como parametros dos atributos
	 * WHEN Se llama al m�todo toString
	 * THEN Se comprueba que el m�todo toString coincide con lo esperado;
	 */
	@Test
	public void testToStringUser1() {
		Photo pic = new Photo(user1, file1);
		String expected = "Photo --> User: " + pic.getUser() + " | File: " + pic.getFile() + 
				"\n\t | Likes: " + pic.getLikes() + " | Comments: " + pic.getComments(); 
		assertEquals(expected, pic.toString());
	}
	
	/**
	 * 1- Recibe un usuario 1
	 * GIVEN Se crea un usuario dado como parametros dos atributos
	 * WHEN Se llama al m�todo toString
	 * THEN Se comprueba que el m�todo toString coincide con lo esperado;
	 */
	@Test
	public void testToStringUser2() {
		Photo pic = new Photo(user2, file2);
		String expected = "Photo --> User: " + pic.getUser() + " | File: " + pic.getFile() + 
				"\n\t | Likes: " + pic.getLikes() + " | Comments: " + pic.getComments(); 
		assertEquals(expected, pic.toString());
	}
	
}
