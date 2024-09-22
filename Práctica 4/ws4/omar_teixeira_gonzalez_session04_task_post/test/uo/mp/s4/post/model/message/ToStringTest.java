package uo.mp.s4.post.model.message;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.post.model.Message;

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
	 * Atributo mensaje
	 */
	private String message1;
	
	/**
	 * Atributo mensaje
	 */
	private String message2;
	
	/**
	 * Creación de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		user1 = "Omitg";
		message1 = "Bienvenido";
		user2="DaneonX";
		message2 = "Buenas tardes";		
	}
	
	/**
	 * Pruebas del método toString de la clase Message:
	 * 1- Recibe un usuario 1
	 * 2- Recibe un usuario 2
	 */
	
	/**
	 * 1- Recibe un usuario 1
	 * GIVEN Se crea un usuario dado como parametros dos atributos
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que el método toString coincide con lo esperado;
	 */
	@Test
	public void testToStringUser1() {
		Message msg = new Message(user1, message1);
		String expected = "Message --> User: " + msg.getUser() + " | msg: " + msg.getMessage() + 
				"\n\t | Likes: " + msg.getLikes() + " | Comments: " + msg.getComments(); 
		assertEquals(expected, msg.toString());
	}
	
	/**
	 * 2- Recibe un usuario 2
	 * GIVEN Se crea un usuario dado como parametros dos atributos
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que el método toString coincide con lo esperado;
	 */
	@Test
	public void testToStringUser2() {
		Message msg = new Message(user2, message2);
		String expected = "Message --> User: " + msg.getUser() + " | msg: " + msg.getMessage() + 
				"\n\t | Likes: " + msg.getLikes() + " | Comments: " + msg.getComments();
		assertEquals(expected, msg.toString());
	}
}
