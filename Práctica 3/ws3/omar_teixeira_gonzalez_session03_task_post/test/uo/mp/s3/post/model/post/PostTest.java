package uo.mp.s3.post.model.post;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s3.post.model.Post;

/**
 * Titulo: Clase PostTest
 * 
 * @author Omitg
 * @version 20-02-2021
 */
public class PostTest {
	
	/**
	 * Pruebas del constructor con par�metros de la clase Item:
	 * Prueba de funcionalidad:
	 * 1- Parametro Titulo valido -> Se crea el objeto
	 * 
	 * Prueba de robustez:
	 * 2- Parametro Titulo null -> Se lanza la excepci�n
	 * 3- Par�metro Titulo palabra vac�a -> Se lanza la excepci�n
	 */
	
//Prueba de funcionalidad:
	/**
	 * 1- Parametro Titulo valido -> Se crea el objeto
	 * GIVEN
	 * WHEN Se pasa un titulo valido
	 * THEN Se crea el objeto
	 */
	@Test
	public void testConstructorValidTitle() {
		Post post = new Post("Omitg");
		assertEquals("Omitg",post.getUser());
	}

//Prueba de robustez:
	/**
	 * 2- Parametro Titulo null -> Se lanza la excepci�n
	 * GIVEN
	 * WHEN Se pasa un titulo no valido (null)
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructorInvalidUser() {
		new Post(null);
	}
	
	/**
	 * 3- Par�metro Titulo palabra vac�a -> Se lanza la excepci�n
	 * GIVEN
	 * WHEN Se pasa un titulo no valido ("")
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructorInvalidUser2() {
		new Post("");
	}
}
