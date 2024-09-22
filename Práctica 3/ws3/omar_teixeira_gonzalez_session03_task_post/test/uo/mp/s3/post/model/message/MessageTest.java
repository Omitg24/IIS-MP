package uo.mp.s3.post.model.message;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s3.post.model.Message;

/**
 * Titulo: Clase MessageTest
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class MessageTest {
//Atributos
	/**
	 * Usuario que escribi� el mensaje
	 */
	private String userName;
	
	/**
	 * Mensaje que public� el usuario
	 */
	private String message;
	
	/**
	 * Creaci�n de atributos para su uso posterior
	 */
	@Before
	public void setUp() {
		userName = "Omitg";
		message = "Im Batman";
	}
	
	/**
	 * Pruebas del constructor con par�metros de la clase Message:
	 * Pruebas de funcionalidad:
	 * 1- Par�metros validos -> Se crea el objeto
	 * 
	 * Pruebas de robustez:
	 * 2- Usuario invalido -> Lanza la excepci�n
	 * 3- Mensaje invalido -> Lanza la excepci�n
	 */
	
//Pruebas de funcionalidad:
	/**
	 * 1- Par�metros validos -> Se crea el objeto
	 * GIVEN
	 * WHEN Se pasa un usuario y mensaje validos
	 * THEN Se crea el objeto
	 */
	@Test
	public void testConstructorValidParams() {
		Message msg = new Message (userName, message);
		assertEquals(userName,msg.getUser());
		assertEquals(message, msg.getMessage());
	}
	
//Pruebas de robustez:
	/**
	 * 2- Usuario invalido -> Lanza la excepci�n
	 * GIVEN
	 * WHEN Se pasa un usuario invalido
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructorInvalidUser() {
		new Message (null,message);
	}
	
	/**
	 * 3- Mensaje invalido -> Lanza la excepci�n
	 * GIVEN
	 * WHEN Se pasa un mensaje invalido
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructorInvalidMessage() {
		new Message (userName,null);
	}
}
